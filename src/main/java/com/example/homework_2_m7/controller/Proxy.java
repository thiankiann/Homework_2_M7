package com.example.homework_2_m7.controller;

import com.example.homework_2_m7.dto.response.GetAllReposResponseDto;
import com.example.homework_2_m7.mappers.ReposMapper;
import com.example.homework_2_m7.service.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "github-client")
@Controller
public class Proxy {

    private final Service service;

    // GET https://api.github.com/users/kalqa/repos
    @GetMapping(path = "/users/{user}/repos" , headers= {"providedHeader"})
    public ResponseEntity<GetAllReposResponseDto> fetchAllRepos(@PathVariable String user, @RequestHeader(required = true) @PathVariable String providedHeader){

        GetAllReposResponseDto response = service.reposRetriever(String user, )
                ReposMapper.mapFromXToGetAllReposResponseDto();
        return ResponseEntity<>;
    }
}
