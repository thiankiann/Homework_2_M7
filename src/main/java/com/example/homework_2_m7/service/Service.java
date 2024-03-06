package com.example.homework_2_m7.service;

import com.example.homework_2_m7.controller.Proxy;
import com.example.homework_2_m7.dto.request.GetAllReposRequestDto;
import com.example.homework_2_m7.mappers.ReposMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@org.springframework.stereotype.Service
public class Service {

    private final Proxy proxy;

    public Service(Proxy proxy) {
        this.proxy = proxy;
    }
    public GetAllReposRequestDto reposRetriever(@PathVariable String user, @RequestHeader(required = true) @PathVariable String providedHeader){

        //from repo
        GetAllReposRequestDto response = ReposMapper.mapFromXToGetAllReposResponseDto();
        return null;

    }
