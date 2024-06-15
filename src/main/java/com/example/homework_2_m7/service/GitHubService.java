package com.example.homework_2_m7.service;

import com.example.homework_2_m7.controller.GitHubServerProxy;
import com.example.homework_2_m7.dto.GitHubResult;
import com.example.homework_2_m7.dto.RepoName;
import com.example.homework_2_m7.dto.RepoUrl;
import com.example.homework_2_m7.mapper.GitHubMapper;
import com.example.homework_2_m7.validate.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Marker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
    public String fetchAllBranchForOneRepo(String owner,String repo) {
        try {
            return gitClient.makeGetRequestBranch(owner,repo);
//            String json = gitClient.makeGetRequestBranch(owner,repo);
//            List<GitHubResult> result = gitHubMapper.mapJsonToGitHubResultList(json);
//            return gitHubMapper.mapResultToResultNoForks(result);
        }catch (HttpClientErrorException ex){
            throw new UserNotFoundException("User: " + owner + repo  + " not found" );
        }

    }

    public List<RepoName> fetchAllReposNames (String username) {
        try {
            String json = gitClient.makeGetRequest(username);
            List<GitHubResult> result = gitHubMapper.mapJsonToGitHubResultList(json);
           return gitHubMapper.mapJsonRepoNamesList(json);
//            List<RepoName> repoName = gitHubMapper.mapJsonRepoNamesList(json);

            //List<RepoName> reposNames = gitHubMapper.mapResultToRepoName(result);

        }catch (HttpClientErrorException ex){
            throw new UserNotFoundException("User: " + username + " not found" );
        }
    }

    public List<RepoUrl> fetchAllReposUrl (String username) {
        try {
            String json = gitClient.makeGetRequest(username);
            List<GitHubResult> result = gitHubMapper.mapJsonToGitHubResultList(json);
            return gitHubMapper.mapJsonRepoUrlList(json);
//            List<RepoName> repoName = gitHubMapper.mapJsonRepoNamesList(json);

            //List<RepoName> reposNames = gitHubMapper.mapResultToRepoName(result);

        }catch (HttpClientErrorException ex){
            throw new UserNotFoundException("User: " + username + " not found" );
        }
    }
//    public Marker fetchAllReposNamesAndPrint (String username) {
//        try {
//            String json = gitClient.makeGetRequest(username);
//            List<GitHubResult> result = gitHubMapper.mapJsonToGitHubResultList(json);
//            // return gitHubMapper.mapJsonRepoNamesList(json);
//            List<RepoName> repoName = gitHubMapper.mapJsonRepoNamesList(json);
//            for (int i = 0; i < repoName.size(); i++)
//            {
//                // E element = list.get(i);
//                fetchAllBranchForOneRepo("kalqa",repoName.get(i).toString());
//               // repoName.get(i);
//            }
//            //List<RepoName> reposNames = gitHubMapper.mapResultToRepoName(result);
//
//        }catch (HttpClientErrorException ex){
//            throw new UserNotFoundException("User: " + username + " not found" );
//        }
//        return null;
//    }
}
