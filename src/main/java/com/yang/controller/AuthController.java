package com.yang.controller;

import com.yang.Model.User;
import com.yang.dto.AccessTokenDto;
import com.yang.dto.GithubUser;
import com.yang.mapper.UserMapper;
import com.yang.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

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

    @Value("${github.Client.id}")
    private String ClientId;

    @Value("${github.Client.secret}")
    private String ClientSecret;

    @Value("${github.Redirect.uri}")
    private String RedirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(ClientId);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(RedirectUri);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_secret(ClientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser userInfo = githubProvider.getUserInfo(accessToken);

        if (userInfo != null) {
            // 将用户信息存入数据库
            User user = new User();
            String token = UUID.randomUUID().toString();
//            user.setId(1);
            user.setAccountId(String.valueOf(userInfo.getId()));
            user.setName(userInfo.getName());
            user.setToken(token);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setPhoto_url(userInfo.getPhoto_url());
            userMapper.insert(user);

            // 将token放入cookie中
            response.addCookie(new Cookie("token", token));

            request.getSession().setAttribute("userInfo", userInfo);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
//        return "index";
    }
}
