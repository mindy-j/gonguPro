package com.example.gongu.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class KaKaoService {

    public String getToken(String code){
        System.out.println(code);
        String url = "https://kauth.kakao.com/oauth/token";
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", "eb7c49991b0158dc6665b43829ddf69a");
        body.add("redirect_uri", "http://localhost:10000/kakaos/code");
        body.add("code", code);

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();

        Map<String, String> resultBody = webClient.post()
                .body(BodyInserters.fromFormData(body))
                .retrieve()
                .bodyToMono(Map.class).block();

        String accessToken = resultBody.get("access_token");

        return accessToken;
    }

    public Map<String, Object> getUserInfo(String accessToken){
        String url = "https://kapi.kakao.com/v2/user/me";

//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("grant_type", "authorization_code");
//        body.add("client_id", "5c90abd03c10e78c64aea0bc8f82b475");
//        body.add("redirect_uri", "http://localhost:10000/kakaos/code");
//        body.add("code", code);

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .defaultHeader("Authorization", "Bearer " + accessToken)
                .build();

        Map<String, Object> resultBody = webClient.post()
//                .body(BodyInserters.fromFormData(body))
                .retrieve()
                .bodyToMono(Map.class).block();

        return resultBody;
    }
}
