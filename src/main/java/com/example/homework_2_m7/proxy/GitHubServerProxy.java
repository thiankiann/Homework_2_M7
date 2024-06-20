package com.example.homework_2_m7.proxy;

import com.example.homework_2_m7.apivalidation.UserNotFoundException;
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


    public String makeGetRequest(String username) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(url)
                .path("/users/" + username + "/repos");
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,// httpEntity,
                    String.class
            );
            return response.getBody();
//        } catch (IllegalArgumentException ex) {
        } catch (RuntimeException  ex) {
            log.error("User: " + username + " not found");
        }
        return null;
    }
    public String makeGetRequestBranch(String owner,String repo) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(url)
             //   .path("/repos/kalqa/LotteryMateusz/branches");
                .path("/repos/" + owner + "/" + repo + "/branches");
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,// httpEntity,
                    String.class
            );
            return response.getBody();
       // } catch (IllegalArgumentException ex) {
        } catch (RuntimeException ex) {
           // log.error("User: " +  owner  + repo  + " not found");
            log.error("ERROR" + ex.getMessage());
        }
        return null;
    }
}