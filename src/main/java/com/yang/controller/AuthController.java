package com.yang.controller;

import com.yang.dto.AccessTokenDto;
import com.yang.dto.GithubUser;
import com.yang.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * github授权访问流程：
 * 1. 本机调用OAUTH接口访问github
 * 2. github返回redirect_uri并且携带code
 * 3. 本机收到code之后调用github的access token并且携带code
 * 4. github返回token
 * 5. 本机用access token调用github的user api
 * 6. github返回user信息
*/

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
