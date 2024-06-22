package com.example.homework_2_m7.repository;

import com.example.homework_2_m7.model.GitHubAllResults;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GitHubRepository extends Repository<GitHubAllResults,Long> {

    GitHubAllResults save(GitHubAllResults results);

    List<GitHubAllResults> findBy();

}
