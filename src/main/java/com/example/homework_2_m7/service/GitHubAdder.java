package com.example.homework_2_m7.service;

import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.repository.GitHubRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class GitHubAdder {
    private final GitHubRepository gitHubRepository;

    public void addRepo(Repo repo) {
        log.info("adding nee Repo: " + repo);
        gitHubRepository.save(repo);
    }

}
