package com.example.homework_2_m7.service;

import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.repository.GitHubRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class GitHubDeleter {
    private final GitHubRepository gitHubRepository;
    private final GitHubRetriever gitHubRetriever;

    public Repo deleteRepo(Long id) {
        gitHubRetriever.findById(id);
        log.info("Deleting song by id: " + id);
        return gitHubRepository.deleteById(id);
    }
}
