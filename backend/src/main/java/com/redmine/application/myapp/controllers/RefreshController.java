package com.redmine.application.myapp.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redmine.application.myapp.entities.SystemUser;
import com.redmine.application.myapp.repositories.SystemUserRepository;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RefreshController {

    static final Logger logger = Logger.getLogger(RefreshController.class);

    private final SystemUserRepository systemUserRepository;

    public RefreshController(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    void addSystemUser(SystemUser systemUser){
            if(!systemUserRepository.existsByLoginAndSystemid(systemUser.getLogin() , systemUser.getSystemid())){
                systemUserRepository.save(systemUser);
            }
        }

    @GetMapping("/refresh")
    public void RefreshList() throws IOException {
        try{
            BasicConfigurator.configure();
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "12345678");
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();

            HttpResponse response = client.execute(new HttpGet("http://localhost:3000/users.json"));

            int statusCode = response.getStatusLine().getStatusCode();

            HttpEntity entity = response.getEntity();

            JSONObject myObject = new JSONObject(EntityUtils.toString(entity));

           //ObjectMapper objectMapper = new ObjectMapper();
            //List<SystemUser> systemUserList = objectMapper.readValue(myObject, new TypeReference<List<SystemUser>>(){});

            JSONArray ArrayOfJsons = myObject.getJSONArray("users");

            for(int i = 0; i < ArrayOfJsons.length(); i++) {
                JSONObject objects = ArrayOfJsons.getJSONObject(i);
                SystemUser systemUser = new SystemUser(objects.get("firstname").toString(),objects.get("lastname").toString(),
                        objects.get("login").toString(),1, Integer.parseInt(objects.get("id").toString()));
                addSystemUser(systemUser);
            }

            response = client.execute(new HttpGet("http://localhost:3010/users.json"));

            statusCode = response.getStatusLine().getStatusCode();

            entity = response.getEntity();

            myObject = new JSONObject(EntityUtils.toString(entity));

            ArrayOfJsons = myObject.getJSONArray("users");

            for(int i = 0; i < ArrayOfJsons.length(); i++) {
                JSONObject objects = ArrayOfJsons.getJSONObject(i);
                SystemUser systemUser = new SystemUser(objects.get("firstname").toString(),objects.get("lastname").toString(),
                        objects.get("login").toString(),2, Integer.parseInt(objects.get("id").toString()));
                addSystemUser(systemUser);
            }

        }
        catch(IOException | JSONException e){
            System.out.println(e);
        }
    }

}
