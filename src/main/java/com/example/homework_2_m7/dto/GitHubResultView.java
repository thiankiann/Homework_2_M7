package com.example.homework_2_m7.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubResultView(String name, Owner owner) {
}
