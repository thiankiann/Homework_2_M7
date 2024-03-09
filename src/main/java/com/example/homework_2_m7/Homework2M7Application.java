package com.example.homework_2_m7;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Log4j2
public class Homework2M7Application {

    @Autowired
    private final MainAppRunner mainAppRunner;

    public Homework2M7Application(MainAppRunner mainAppRunner) {
        this.mainAppRunner = mainAppRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(Homework2M7Application.class, args);
    }


    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        mainAppRunner.start();
    }
}
