package com.yang.controller;

import com.yang.dto.AccessTokenDto;
import com.yang.dto.GithubUser;
import com.yang.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) throws IOException {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("202bcdd7698d4ea65460");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDto.setState(state);
        accessTokenDto.setClient_secret("112ab4e98d7f25dc97ef70a3e9e16121723dfa73");
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser userInfo = githubProvider.getUserInfo(accessToken);
        System.out.println(userInfo.getName());
        return "index";
    }
}
