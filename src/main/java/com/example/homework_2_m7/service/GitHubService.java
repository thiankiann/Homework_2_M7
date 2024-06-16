package com.example.homework_2_m7.service;

import com.example.homework_2_m7.controller.GitHubServerProxy;
import com.example.homework_2_m7.dto.*;
import com.example.homework_2_m7.mapper.GitHubMapper;
import com.example.homework_2_m7.validate.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Marker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class GitHubService {

    private final GitHubServerProxy gitClient;
    private final GitHubMapper gitHubMapper;

    public GitHubService(GitHubServerProxy gitClient, GitHubMapper gitHubMapper) {
        this.gitClient = gitClient;
        this.gitHubMapper = gitHubMapper;
    }
    public List<GitHubResult> fetchAllRepos(String username) {
        try {
            String json = gitClient.makeGetRequest(username);
            List<GitHubResult> result = gitHubMapper.mapJsonToGitHubResultList(json);
            return gitHubMapper.mapResultToResultNoForks(result);
        }catch (HttpClientErrorException ex){
            throw new UserNotFoundException("User: " + username + " not found" );
        }
    }
    public List<BranchResult> fetchShaBranchesForOneRepo(String owner, String repo) {
        try {
            String json = gitClient.makeGetRequestBranch(owner,repo);
            return gitHubMapper.mapJsonToBranchResultList(json);
        }catch (HttpClientErrorException ex){
            throw new UserNotFoundException("User: " + owner + repo  + " not found" );
        }
    }
    public AllInfoFomGitHubList fetchAllRequiredResults(String username){
        List<GitHubResult> results = fetchAllRepos(username);
        List<AllInfoFomGitHub> allInfo = new ArrayList<>();

        for(GitHubResult result : results){
            List<BranchResult> branchResults = fetchShaBranchesForOneRepo(result.owner().login(), result.name());
            AllInfoFomGitHub allInfoFomGitHub = new AllInfoFomGitHub(result.name(),result.owner(),branchResults);
            allInfo.add(allInfoFomGitHub);
        }
        return new AllInfoFomGitHubList(allInfo);
    }
}
