package com.example.homework_2_m7.repository;

import com.example.homework_2_m7.model.Repo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    @Modifying
    @Query("UPDATE Repo r SET r.name = :#{#newRepo.name}, r.owner = :#{#newRepo.owner} WHERE r.id = :id")
    void updateById(Long id, Repo newRepo);
}

