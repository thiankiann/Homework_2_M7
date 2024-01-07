package com.example.homework_2_m7;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "github-client")
@Service
public interface Proxy {


    // GET http://api.github.com
    @GetMapping("/users/kalqa/repos")
    public String fetchAllRepos();
}
