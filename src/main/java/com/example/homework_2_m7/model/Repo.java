package com.example.homework_2_m7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
//@AllArgsConstructor
@Table(name = "repo")
public class Repo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    String owner;

    public Repo() {
    }

    public Repo(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public Repo(Long id, String name, String owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }
}
