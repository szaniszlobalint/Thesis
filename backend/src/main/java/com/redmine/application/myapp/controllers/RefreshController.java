package com.redmine.application.myapp.controllers;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RefreshController {

    @GetMapping("/refresh")
    public String RefreshList() throws IOException {
        try{
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "12345678");
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();

            HttpResponse response = client.execute(
                    new HttpGet("http://localhost:3000/users.json"));
            int statusCode = response.getStatusLine()
                    .getStatusCode();
            HttpEntity entity = response.getEntity();

            JSONObject myObject = new JSONObject(EntityUtils.toString(entity));

            JSONArray ArrayOfJsons = myObject.getJSONArray("users");

            for(int i = 0; i < ArrayOfJsons.length(); i++) {
                JSONObject objects = ArrayOfJsons.getJSONObject(i);
                System.out.println(objects);
            }

            return "ok";
        }
        catch(IOException | JSONException e){
            System.out.println(e);
            return null;
        }
    }

}
