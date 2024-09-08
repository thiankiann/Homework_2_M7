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
public class GitHubUpdater {
    private final GitHubRepository gitHubRepository;

    public void updateByid(Long id, Repo newRepo) {
        gitHubRepository.updateById(id,newRepo);
    }


}
