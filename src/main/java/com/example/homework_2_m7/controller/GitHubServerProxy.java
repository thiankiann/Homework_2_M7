package com.example.homework_2_m7.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
@Log4j2
public class GitHubServerProxy {

    @Autowired
    RestTemplate restTemplate;

    public GitHubServerProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("api.github.com")
    String url;

//    @Value("${github-server.service.port}")
//    int port;
//     GET https://api.github.com/users/kalqa/repos

    public String fetchAllRepos() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(url)
                .path("/users/kalqa/repos");
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,// httpEntity,
                    String.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}