package com.yang.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yang.dto.AccessTokenDto;
import com.yang.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class GithubProvider {

    /**
     * 获取AccessToken
     *
     * @param accessTokenDto
     * @return
     */
    public String getAccessToken(AccessTokenDto accessTokenDto) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String[] split1 = string.split("&");
            String token_string = split1[0];
            String token = token_string.split("=")[1];
            return token;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUserInfo(String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
//                .header("Authorization", "token" + accessToken)
                .build();
        Response response = client.newCall(request).execute();
        String string = response.body().string();
        GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
        return githubUser;
    }
}
