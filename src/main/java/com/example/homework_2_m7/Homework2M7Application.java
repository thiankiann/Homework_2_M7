package com.example.homework_2_m7;

import com.example.homework_2_m7.controller.GitHubServerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
public class Homework2M7Application {

    @Autowired
    GitHubServerProxy githubClient;

    public Homework2M7Application(GitHubServerProxy githubClient) {
        this.githubClient = githubClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(Homework2M7Application.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeResponseToSongifyEndpoint() {

//        System.out.println(githubClient.makeGetRequest("kalqa"));
        System.out.println(githubClient.fetchAllRepos());
    }
}
