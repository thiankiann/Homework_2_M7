package com.example.homework_2_m7.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public record ShaBranchesForAllRepos(String owner, String name) {
}
