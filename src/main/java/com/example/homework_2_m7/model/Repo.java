package com.example.homework_2_m7.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Builder

@Table(name = "repo")
public class Repo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String owner;
    String name;

    public Repo() {
    }

    public Repo(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }
}
