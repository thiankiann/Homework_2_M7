package com.example.homework_2_m7.repository;

import com.example.homework_2_m7.model.Repo;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface GitHubRepository extends Repository<Repo,Long> {

    Repo save(Repo results);

//    Repo findBy(Long id);
    List<Repo> findAll();

    Repo deleteById(Long id);


    Repo findById(Long id);

    void updateById(Long id, Repo newRepo);
}

