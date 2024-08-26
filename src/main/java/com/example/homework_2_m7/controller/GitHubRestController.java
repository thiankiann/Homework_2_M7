package com.example.homework_2_m7.controller;

import com.example.homework_2_m7.model.ReposDatabaseList;
import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.proxy.dto.AllInfoFromGitHub;
import com.example.homework_2_m7.proxy.dto.AllInfoFromGitHubList;
import com.example.homework_2_m7.service.GitHubAdder;
import com.example.homework_2_m7.service.GitHubRetriever;
import com.example.homework_2_m7.service.GitHubService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/repos")
public class GitHubRestController {
    public final GitHubService gitHubService;
    public final GitHubAdder gitHubAdder;
    public final GitHubRetriever gitHubRetriever;
   // GitHubRepository repository;

//   @GetMapping( "/{user}")

  @GetMapping(  path = "/{user}", headers = "Accept=application/json")
    public ResponseEntity<AllInfoFromGitHubList> getAllRequiredResults (@PathVariable String user) {
       List<AllInfoFromGitHub> allInfoList = gitHubService.fetchAllRequiredResults(user).allInfoList();
       gitHubService.addingGitHubListToDB(allInfoList);
       AllInfoFromGitHubList response = new AllInfoFromGitHubList(allInfoList) ;


        return ResponseEntity.ok(response);
    }
//@GetMapping(path = "/{user}" , headers = "Accept=application/xml")
//    public ResponseEntity<ErrorResponseDto> getAllRequiredResults( ){
//    ErrorResponseDto response = new ErrorResponseDto(HttpStatus.NOT_ACCEPTABLE, "xml is not acceptable - change to json");
//    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
//    }


    @GetMapping("/database")
    public ResponseEntity<ReposDatabaseList> getAllInfoFromDB(){
        List<Repo> reposDatabaseObjects = gitHubRetriever.findAll();
        ReposDatabaseList reposDatabaseList = new ReposDatabaseList(reposDatabaseObjects);

        return ResponseEntity.ok(reposDatabaseList);
    }

    @PostMapping()
    public ResponseEntity<Repo> postGitHubIntoDB(@RequestBody Repo repo){ //(String owner , String name)){

      gitHubAdder.addRepo(repo);
      return ResponseEntity.ok(repo);
    }
}
