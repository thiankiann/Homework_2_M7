package com.example.homework_2_m7.model;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
//@Builder
public class GitHubAllResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String owner;
    String name;

    public GitHubAllResults() {
    }

    public GitHubAllResults(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }
}
