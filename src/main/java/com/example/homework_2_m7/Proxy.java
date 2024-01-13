package com.example.homework_2_m7;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "github-client")
@Service
public interface Proxy {


    // GET http://api.github.com
    @GetMapping(path = "/users/{user}/repos" , headers= {"providedHeader"})
    public String fetchAllRepos(@PathVariable String user, @RequestHeader(required = true) @PathVariable String providedHeader);
}
