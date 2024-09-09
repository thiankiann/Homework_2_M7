package com.example.homework_2_m7.service;

import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.repository.GitHubRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional
@AllArgsConstructor
public class GitHubUpdatePartially {
    private final GitHubRepository gitHubRepository;
    private final GitHubRetriever gitHubRetriever;

    public void updatePartiallyById(Long id, Repo newRepo) {

        log.info("updating repository with ID: " + id);

        Repo oldRepo = gitHubRetriever.findRepoById(id);
        Repo.RepoBuilder builder = Repo.builder();
        if(newRepo.getName() != null){
            builder.name(newRepo.getName());
        } else {
            builder.name(oldRepo.getName());
        }
        if(newRepo.getOwner() != null){
            builder.owner(newRepo.getOwner());
        } else {
            builder.owner(oldRepo.getOwner());
        }
        Repo repoToUpdate = builder.build();

        gitHubRepository.updateById(id,repoToUpdate);
    }
}
