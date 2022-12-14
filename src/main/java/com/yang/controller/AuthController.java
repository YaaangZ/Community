package com.yang.controller;

import com.yang.Model.User;
import com.yang.Service.UserService;
import com.yang.Dto.AccessTokenDto;
import com.yang.Dto.GithubUser;
import com.yang.Provider.GithubProvider;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
    private UserService userService;

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

        if (userInfo != null && userInfo.getId() != null) {
            // 将用户信息存入数据库
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setAccountId(String.valueOf(userInfo.getId()));
            user.setName(userInfo.getName());
            user.setToken(token);
            user.setPhotoUrl(userInfo.getPhoto_url());
            userService.createOrUpdate(user);

            // 将token放入cookie中
            Cookie cookie = new Cookie("token", token);
            response.addCookie(cookie);
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            cookie.setPath("/");
            response.addCookie(cookie);
            request.getSession().setAttribute("userInfo", userInfo);
            return "redirect:/";
        } else {
            log.error("callback get github error, {}", userInfo);
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
//        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }
}
