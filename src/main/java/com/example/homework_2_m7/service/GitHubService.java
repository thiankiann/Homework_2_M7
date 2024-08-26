package com.example.homework_2_m7.service;

import com.example.homework_2_m7.model.Repo;
import com.example.homework_2_m7.proxy.GitHubServerProxy;
import com.example.homework_2_m7.mapper.GitHubMapper;
import com.example.homework_2_m7.proxy.dto.AllInfoFromGitHub;
import com.example.homework_2_m7.proxy.dto.AllInfoFromGitHubList;
import com.example.homework_2_m7.proxy.dto.BranchResult;
import com.example.homework_2_m7.proxy.dto.GitHubResult;
import com.example.homework_2_m7.apivalidation.UserNotFoundException;
import com.example.homework_2_m7.repository.GitHubRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class GitHubService {

    private final GitHubServerProxy gitClient;
    private final GitHubMapper gitHubMapper;
    private final GitHubRepository gitHubRepository;

//    public GitHubService(GitHubServerProxy gitClient, GitHubMapper gitHubMapper) {
//        this.gitClient = gitClient;
//        this.gitHubMapper = gitHubMapper;
//    }
    public List<GitHubResult> fetchAllRepos(String username) {
        try {
            String json = gitClient.makeGetRequest(username);
        return  gitHubMapper.mapJsonToGitHubResultList(json)
                        .stream()
                        .filter(gitHubResult -> !gitHubResult.fork())
                        .toList();
        }catch (RuntimeException ex){
            throw new UserNotFoundException("User: " + username + " not found!!!" );
        }
    }
    public List<BranchResult> fetchShaBranchesForOneRepo(String owner, String repo) {
//        try {
            String json = gitClient.makeGetRequestBranch(owner,repo);
            return gitHubMapper.mapJsonToBranchResultList(json);
//        }catch (HttpClientErrorException ex){
//            throw new UserNotFoundException("User: " + owner + repo  + " not found" );
//        }
    }
    public AllInfoFromGitHubList fetchAllRequiredResults(String username){
        List<GitHubResult> results = fetchAllRepos(username);
        List<AllInfoFromGitHub> allInfo = new ArrayList<>();

        for(GitHubResult result : results){
            List<BranchResult> branchResults = fetchShaBranchesForOneRepo(result.owner().login(), result.name());
            log.info(branchResults);
            AllInfoFromGitHub allInfoFromGitHub = new AllInfoFromGitHub(result.name(),result.owner(),branchResults);
            allInfo.add(allInfoFromGitHub);
        }
        return new AllInfoFromGitHubList(allInfo);
    }

    public void addingGitHubListToDB(List<AllInfoFromGitHub> allInfoList) {
        for (AllInfoFromGitHub info : allInfoList
             ) {
            Repo repo = new Repo(info.owner().toString(), info.name());
            gitHubRepository.save(repo);
        }


//            allInfoList.stream()
//                    .map(repos -> new Repo(
//                            allInfoList.getOwner(),
//                            allInfoList.getName()
//                    ))
//                    .collect(Collectors.toList());

    }
}
