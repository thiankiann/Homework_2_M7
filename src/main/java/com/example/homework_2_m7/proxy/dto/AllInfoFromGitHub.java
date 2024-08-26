package com.example.homework_2_m7.proxy.dto;

import java.util.List;


public record AllInfoFromGitHub(String name, Owner owner, List<BranchResult> branchResults) {
}