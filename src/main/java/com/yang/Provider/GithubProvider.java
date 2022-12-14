package com.yang.Provider;

import com.alibaba.fastjson.JSON;
import com.yang.Dto.AccessTokenDto;
import com.yang.Dto.GithubUser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class GithubProvider {
    @Value("${github.Client.id}")
    private String clientId;

    @Value("${github.Client.secret}")
    private String clientSecret;

    @Value("${github.Redirect.uri}")
    private String redirectUri;

    /**
     * 获取AccessToken并返回token
     *
     * @param accessTokenDto
     * @return
     */
    public String getAccessToken(AccessTokenDto accessTokenDto) {
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setRedirect_uri(redirectUri);

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;

        } catch (IOException e) {
            log.error("getAccessToken error,{}", accessTokenDto, e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用access token调用GitHub的user api, 返回user信息
     *
     * @param accessToken
     * @return
     * @throws IOException
     */
    public GithubUser getUserInfo(String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "token " + accessToken)
                .build();
//        Request request = new Request.Builder()
//                .url("https://api.github.com/user?access_token=" + accessToken)
//                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (Exception e) {
            log.error("getUser error,{}", accessToken, e);
        }
        return null;
    }
}

