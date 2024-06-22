package com.example.homework_2_m7.repository;

import com.example.homework_2_m7.model.Repo;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GitHubRepository extends Repository<Repo,Long> {

    Repo save(Repo results);

    List<Repo> findBy();

}
