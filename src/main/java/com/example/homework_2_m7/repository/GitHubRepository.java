package com.example.homework_2_m7.repository;

import com.example.homework_2_m7.model.Repo;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface GitHubRepository extends Repository<Repo,Long> {

    Repo save(Repo results);

    List<Repo> findBy();
    List<Repo> findAll();

}
