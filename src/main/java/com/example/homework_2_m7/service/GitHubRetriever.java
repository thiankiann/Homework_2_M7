package com.example.homework_2_m7.service;

import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.repository.GitHubRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class GitHubRetriever {
    private final GitHubRepository gitHubRepository;

    public GitHubRetriever(GitHubRepository gitHubRepository) {
        this.gitHubRepository = gitHubRepository;
    }

    public List<Repo> findAll() {
        log.info("retrieving all repos:");
        return gitHubRepository.findAll();
    }
}
