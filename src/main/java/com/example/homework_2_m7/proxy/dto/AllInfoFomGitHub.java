package com.example.homework_2_m7.proxy.dto;

import java.util.List;


public record AllInfoFomGitHub(String name, Owner owner, List<BranchResult> branchResults) {
}