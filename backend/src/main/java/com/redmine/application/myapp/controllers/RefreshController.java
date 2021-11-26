package com.redmine.application.myapp.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redmine.application.myapp.entities.Project;
import com.redmine.application.myapp.entities.RedProjectOriginal;
import com.redmine.application.myapp.entities.SystemUser;
import com.redmine.application.myapp.entities.RedmineOriginal;
import com.redmine.application.myapp.repositories.ProjectRepository;
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

    ObjectMapper objectMapper = new ObjectMapper();
    //objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    static final Logger logger = Logger.getLogger(RefreshController.class);

    private final SystemUserRepository systemUserRepository;

    private final ProjectRepository projectRepository;

    public RefreshController(SystemUserRepository systemUserRepository, ProjectRepository projectRepository) {
        this.systemUserRepository = systemUserRepository;
        this.projectRepository = projectRepository;
    }

    void addSystemUser(SystemUser systemUser){
            if(!systemUserRepository.existsByLoginAndSystemid(systemUser.getLogin() , systemUser.getSystemid())){
                systemUserRepository.save(systemUser);
            }
    }

    void addProject(Project project){
        if(!projectRepository.existsByNameAndSystemid(project.getName() , project.getSystemid())){
            projectRepository.save(project);
        }
    }

    @GetMapping("/refreshusers")
    public void RefreshUsersList() throws IOException {
        try{
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

            List<RedmineOriginal> redmineUserList = objectMapper.readValue(myObject.getString("users"), new TypeReference<List<RedmineOriginal>>(){});

            //JSONArray ArrayOfJsons = myObject.getJSONArray("users");
            for (RedmineOriginal redmineUser : redmineUserList) {
                //logger.info(systemUserList.get(i));
                //JSONObject objects = ArrayOfJsons.getJSONObject(i);
                SystemUser systemUser = new SystemUser(redmineUser.getFirstname(), redmineUser.getLastname(),
                        redmineUser.getLogin(), 1, redmineUser.getId());
                addSystemUser(systemUser);
            }

            response = client.execute(new HttpGet("http://localhost:3010/users.json"));

            statusCode = response.getStatusLine().getStatusCode();

            entity = response.getEntity();

            myObject = new JSONObject(EntityUtils.toString(entity));

            redmineUserList = objectMapper.readValue(myObject.getString("users"), new TypeReference<List<RedmineOriginal>>(){});

            //ArrayOfJsons = myObject.getJSONArray("users");

            for (RedmineOriginal redmineUser : redmineUserList) {
                //JSONObject objects = ArrayOfJsons.getJSONObject(i);
                SystemUser systemUser = new SystemUser(redmineUser.getFirstname(), redmineUser.getLastname(),
                        redmineUser.getLogin(), 2, redmineUser.getId());
                addSystemUser(systemUser);
            }

        }
        catch(IOException | JSONException e){
            System.out.println(e);
        }
    }

    @GetMapping("/refreshprojects")
    public void RefreshProjectsList() throws IOException {
        try{
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "12345678");
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();

            HttpResponse response = client.execute(new HttpGet("http://localhost:3000/projects.json"));

            int statusCode = response.getStatusLine().getStatusCode();

            HttpEntity entity = response.getEntity();

            JSONObject myObject = new JSONObject(EntityUtils.toString(entity));

            List<RedProjectOriginal> redmineProjectList = objectMapper.readValue(myObject.getString("projects"), new TypeReference<List<RedProjectOriginal>>(){});

            //JSONArray ArrayOfJsons = myObject.getJSONArray("users");
            for (RedProjectOriginal redmineProject : redmineProjectList) {
                //logger.info(systemUserList.get(i));
                //JSONObject objects = ArrayOfJsons.getJSONObject(i);
                Project project = new Project(redmineProject.getName(), redmineProject.getIdentifier(),  1, redmineProject.getId());
                addProject(project);
            }

            response = client.execute(new HttpGet("http://localhost:3010/projects.json"));

            statusCode = response.getStatusLine().getStatusCode();

            entity = response.getEntity();

            myObject = new JSONObject(EntityUtils.toString(entity));

            redmineProjectList = objectMapper.readValue(myObject.getString("projects"), new TypeReference<List<RedProjectOriginal>>(){});

            //ArrayOfJsons = myObject.getJSONArray("users");

            for (RedProjectOriginal redmineProject : redmineProjectList) {
                //JSONObject objects = ArrayOfJsons.getJSONObject(i);
                Project project = new Project(redmineProject.getName(), redmineProject.getIdentifier(),  2, redmineProject.getId());
                addProject(project);
            }

        }
        catch(IOException | JSONException e){
            System.out.println(e);
        }
    }

}
