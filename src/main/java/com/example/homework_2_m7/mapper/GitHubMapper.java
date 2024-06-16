package com.example.homework_2_m7.mapper;

import com.example.homework_2_m7.dto.GitHubResult;
import com.example.homework_2_m7.dto.BranchResult;
import com.example.homework_2_m7.dto.RepoUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Log4j2
@Component
public class GitHubMapper {

    private final ObjectMapper objectMapper;

    public GitHubMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<GitHubResult> mapJsonToGitHubResultList(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return Collections.emptyList();
        }
    }
//    public List<BranchResult> mapJsonRepoNamesList(String json) {
//        try {
//            return objectMapper.readValue(json, new TypeReference<>() {
//            });
//        } catch (JsonProcessingException e) {
//            log.error(e.getMessage());
//            return Collections.emptyList();
//        }
//    }
//    public List<RepoUrl> mapJsonRepoUrlList(String json) {
//        try {
//            return objectMapper.readValue(json, new TypeReference<>() {
//            });
//        } catch (JsonProcessingException e) {
//            log.error(e.getMessage());
//            return Collections.emptyList();
//        }
//    }
    public List<GitHubResult> mapResultToResultNoForks(List<GitHubResult> result) {
        return result.stream()
                .filter(gitHubResult -> !gitHubResult.fork())
                .toList();
    }

    public List<BranchResult> mapJsonToBranchResultList(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return Collections.emptyList();
        }
    }


//    public List<RepoName> mapResultToRepoName(List<GitHubResult> result) {
//        return result.stream()
//                //.map().filter(repoName -> result.getName())
//                .map(repoName -> new RepoName(
//                        result.getName()
//                ))
//                .collect(Collectors.toSet());
//               // .toList();
//    }
//    .map(artist -> new ArtistDto(
//            artist.getId(),
//                        artist.getName()
//                                ))
//                                .collect(Collectors.toSet());

}


