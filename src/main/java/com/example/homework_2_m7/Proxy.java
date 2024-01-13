package com.example.homework_2_m7;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
@Log4j2
public class Proxy {
//    @GetMapping("/users/kalqa/repos")
//    public String fetchAllRepos(){
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    public Proxy(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @Value("${github-server.service.url}")
//    String url;
//
//    @Value("${github-server.service.port}")
//    int port;
    // GET http://api.github.com/users/kalqa/repos

//    }
//    public String fetchAllRepos() {
//        UriComponentsBuilder builder = UriComponentsBuilder
//                .newInstance()
//                .scheme("http")
//                .host(url)
//                .port(port)
//                .path("/users/kalqa/repos");
//
//        try {
//            ResponseEntity<String> response = restTemplate.exchange(
//                    builder.build().toUri(),
//                    HttpMethod.GET,
//                    null,// httpEntity,
//                    String.class
//            );
//            return response.getBody();
//        } catch (RestClientResponseException exception) {
//            log.error(exception.getStatusText() + " " + exception.getStatusCode().value());
//        } catch (RestClientException exception) {
//            log.error(exception.getMessage());
//        }
//        return null;
//    }
    @Autowired
    RestTemplate restTemplate;

    public Proxy(RestTemplate restTemplate) {
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
//        try {
//            ResponseEntity<String> response = restTemplate.exchange(
//                    builder.build().toUri(),
//                    HttpMethod.GET,
//                    null,// httpEntity,
//                    String.class
//            );
//            return response.getBody();
//        } catch (RestClientResponseException exception) {
//            log.error(exception.getStatusText() + " " + exception.getStatusCode().value());
//        } catch (RestClientException exception) {
//            log.error(exception.getMessage());
//        }
        //return null;
    }
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Value("api.github.com")
//    String url;
//
//
//
//
//    public String makeGetRequest(String username) {
//        UriComponentsBuilder builder = UriComponentsBuilder
//                .newInstance()
//                .scheme("https")
//                .host(url)
//                .path("/users/" + username + "/repos");
//
//        try {
//            ResponseEntity<String> response = restTemplate.exchange(
//                    builder.build().toUri(),
//                    HttpMethod.GET,
//                    null,
//                    String.class
//            );
//            return response.getBody();
//        } catch (IllegalArgumentException ex) {
//            log.error("User: " + username + " not found");
//        }
//        return null;
//    }
}
