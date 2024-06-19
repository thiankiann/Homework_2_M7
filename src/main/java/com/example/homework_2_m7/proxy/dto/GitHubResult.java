package com.example.homework_2_m7.proxy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubResult(String name, boolean fork,  Owner owner) {
}