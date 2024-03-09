package com.example.homework_2_m7.service;

import com.example.homework_2_m7.controller.GitHubServerProxy;
import com.example.homework_2_m7.dto.GitHubResult;
import com.example.homework_2_m7.mapper.GitHubMapper;
import com.example.homework_2_m7.validate.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
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
            List<GitHubResult> mapResultToResultWithoutFork =gitHubMapper.mapResultToResultWithoutFork(result);
            return mapResultToResultWithoutFork;
        }catch (HttpClientErrorException ex){
            throw new UserNotFoundException("User: " + username + " not found" );
        }
    }
}
