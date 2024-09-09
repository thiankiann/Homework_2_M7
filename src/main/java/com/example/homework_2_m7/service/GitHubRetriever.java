package com.example.homework_2_m7.service;

import com.example.homework_2_m7.apivalidation.IdNotFoundException;
import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.repository.GitHubRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class GitHubRetriever {
    private final GitHubRepository gitHubRepository;

    public List<Repo> findAll() {
        log.info("retrieving all repos:");
        return gitHubRepository.findAll();
    }

    public Repo findRepoById(Long id) {
        log.info("finding Repository by id: " + id);
        if (gitHubRepository.findById(id) == null){
            throw new IdNotFoundException("id: " + id + "not found");
        }
        return gitHubRepository.findById(id);
    }
}
