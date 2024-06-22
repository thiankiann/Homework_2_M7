package com.example.homework_2_m7.controller;

import com.example.homework_2_m7.apivalidation.ErrorResponseDto;

import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.proxy.dto.AllInfoFomGitHub;
import com.example.homework_2_m7.proxy.dto.AllInfoFomGitHubList;
import com.example.homework_2_m7.repository.GitHubRepository;
import com.example.homework_2_m7.service.GitHubService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/repos")
public class GitHubRestController {
    GitHubService gitHubService;
   // GitHubRepository repository;

//   @GetMapping( "/{user}")

  @GetMapping(  path = "/{user}", headers = "Accept=application/json")
    public ResponseEntity<AllInfoFomGitHubList> getAllRequiredResults ( @PathVariable String user) {
       List<AllInfoFomGitHub> allInfoList = gitHubService.fetchAllRequiredResults(user).allInfoList();
       gitHubService.addingGitHubListToDB(allInfoList);
       AllInfoFomGitHubList response = new AllInfoFomGitHubList(allInfoList) ;

        return ResponseEntity.ok(response);
    }
//@GetMapping(path = "/{user}" , headers = "Accept=application/xml")
//    public ResponseEntity<ErrorResponseDto> getAllRequiredResults( ){
//    ErrorResponseDto response = new ErrorResponseDto(HttpStatus.NOT_ACCEPTABLE, "xml is not acceptable - change to json");
//    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
//    }
}
