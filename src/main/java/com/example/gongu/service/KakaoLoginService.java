package com.example.gongu.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@Component
public class KakaoLoginService {
    String kakaoRestAPIKey = "c9832199f86179356cfa730b33000a87";
    String redirectUri = "http://localhost:10000/auth/kako";
    String kakaoApiUrl ="https://kauth.kakao.com/oauth/token";
    String dataUrl = "https://kapi.kakao.com/v2/user/me";

    public ResponseEntity<String> kakaoLoginProcess(String code) throws Exception{
        log.info("Call Post logic");
        final String grant_type = "authorization_code";
        log.info("call KakaoRestApiKey : "+ kakaoRestAPIKey);
        log.info("call redirect uri : " + redirectUri);
        log.info("Call KakaoRestAPiKEY : "+ kakaoApiUrl);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grant_type);
        params.add("client_id", kakaoRestAPIKey);
        params.add("redirect_uri", redirectUri);
        params.add("code",code);

        ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(kakaoApiUrl, params, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            log.info("Success response");
            String responseBody = responseEntity.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            String accessToken = jsonNode.get("access_token").asText();
            String tokenType = jsonNode.get("token_type").asText();

            log.info("Access Token : " + accessToken);
            log.info("Token type : " + tokenType);

            responseEntity = getAgreementInfo(accessToken);
            return  responseEntity;
        }else{
            log.info("Fail login response");
            return null;
        }
    }

    public ResponseEntity<String> getAgreementInfo(String accessToken) throws Exception{
        log.info("Call getAgreement");
        log.info("call AccessToken : " + accessToken);
        log.info("call datauUrl : "+ dataUrl);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization","Bearer"+accessToken);
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(dataUrl, HttpMethod.GET, kakaoProfileRequest,String.class);
        log.info(response.getBody());

        return response;
    }

}
