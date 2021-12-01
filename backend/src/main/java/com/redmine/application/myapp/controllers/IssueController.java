package com.redmine.application.myapp.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redmine.application.myapp.entities.*;
import com.redmine.application.myapp.repositories.ProjectPairRepository;
import com.redmine.application.myapp.repositories.ProjectRepository;
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
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IssueController {

    static final Logger logger = Logger.getLogger(RefreshController.class);

    private final ProjectRepository projectRepository;
    private final ProjectPairRepository projectPairRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public IssueController(ProjectRepository projectRepository, ProjectPairRepository projectPairRepository) {
        this.projectRepository = projectRepository;
        this.projectPairRepository = projectPairRepository;
    }

    @GetMapping("/synchronizeissues")
    public void SynchronizeIssues() {
        try{
            List<ProjectPair> projectPairs = (List<ProjectPair>) projectPairRepository.findAll();
            List<Project> projects = (List<Project>) projectRepository.findAll();
            List<Issue> aProjectIssues = new ArrayList<Issue>();
            List<Issue> bProjectIssues = new ArrayList<Issue>();

            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "12345678");
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();

            for (Project project : projects) {
                if (projectPairRepository.existsByAid(project.getRedmineid()) && project.getSystemid() == 1) {
                    HttpResponse response = client.execute(new HttpGet("http://localhost:3000/issues.json?project_id=" + project.getRedmineid()));

                    int statusCode = response.getStatusLine().getStatusCode();

                    HttpEntity entity = response.getEntity();

                    JSONObject myObject = new JSONObject(EntityUtils.toString(entity));

                    List<RedIssueOriginal> redmineIssueList = objectMapper.readValue(myObject.getString("issues"), new TypeReference<List<RedIssueOriginal>>() {
                    });


                    for (RedIssueOriginal redmineIssue : redmineIssueList) {
                        Issue issue = new Issue(redmineIssue.getId(),redmineIssue.getTracker().getId(),redmineIssue.getSubject(),
                                redmineIssue.getAssigned_to().getId(),redmineIssue.getStatus().getId(),
                                redmineIssue.getPriority().getId(), 1, redmineIssue.getProject().getID());
                        aProjectIssues.add(issue);
                    }

                }
            }

            for (Project project : projects) {
                if (project.getSystemid() == 2) {
                    HttpResponse response = client.execute(new HttpGet("http://localhost:3010/issues.json?project_id=" + project.getRedmineid()));

                    int statusCode = response.getStatusLine().getStatusCode();

                    HttpEntity entity = response.getEntity();

                    JSONObject myObject = new JSONObject(EntityUtils.toString(entity));

                    List<RedIssueOriginal> redmineIssueList = objectMapper.readValue(myObject.getString("issues"), new TypeReference<List<RedIssueOriginal>>() {
                    });


                    for (RedIssueOriginal redmineIssue : redmineIssueList) {
                        Issue issue = new Issue(redmineIssue.getId(),redmineIssue.getTracker().getId(),redmineIssue.getSubject(),
                                redmineIssue.getAssigned_to().getId(),redmineIssue.getStatus().getId(),
                                redmineIssue.getPriority().getId(), 2, redmineIssue.getProject().getID());
                        bProjectIssues.add(issue);
                    }
                }
            }

            for (Issue aIssue : aProjectIssues){
                boolean found = false;
                for(Issue bIssue: bProjectIssues){
                    if(bIssue.getSubject().contains("(#"+ aIssue.getId() + ")")){
                        found = true;
                        break;
                    }
                }
                if(!found){
                   logger.info(aIssue);
                }
            }

        }
        catch(IOException | JSONException e){
            System.out.println(e);
        }
    }

}
