package com.example.homework_2_m7;

import com.example.homework_2_m7.service.GitHubService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MainAppRunner {

    GitHubService gitHubService;

    public MainAppRunner(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    public void start() {
        log.info(gitHubService.fetchAllRepos("kalqa"));
    }
}
