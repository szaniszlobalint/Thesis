package com.redmine.application.myapp.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redmine.application.myapp.entities.*;
import com.redmine.application.myapp.repositories.ProjectPairRepository;
import com.redmine.application.myapp.repositories.ProjectRepository;
import com.redmine.application.myapp.repositories.SystemUserPairRepository;
import com.redmine.application.myapp.repositories.SystemUserRepository;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
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

    static final Logger logger = Logger.getLogger(IssueController.class);

    private final ProjectRepository projectRepository;
    private final SystemUserRepository systemUserRepository;
    private final ProjectPairRepository projectPairRepository;
    private final SystemUserPairRepository systemUserPairRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public IssueController(ProjectRepository projectRepository, SystemUserRepository systemUserRepository,
                           ProjectPairRepository projectPairRepository, SystemUserPairRepository systemUserPairRepository) {
        this.projectRepository = projectRepository;
        this.systemUserRepository = systemUserRepository;
        this.projectPairRepository = projectPairRepository;
        this.systemUserPairRepository = systemUserPairRepository;
    }

    @GetMapping("/synchronizeissues") // add systemPairId=id
    public String SynchronizeIssues() {
        try{
            // Get systemPair
            // Get aProjects from aSystem which has any pair
            // projectpair, function with and without method

            List<ProjectPair> projectPairs = (List<ProjectPair>) projectPairRepository.findAll();
            List<SystemUserPair> userPairs = (List<SystemUserPair>) systemUserPairRepository.findAll();
            List<Project> projects = (List<Project>) projectRepository.findAll();
            List<SystemUser> systemUsers = (List<SystemUser>) systemUserRepository.findAll();
            List<Issue> aProjectIssues = new ArrayList<Issue>();
            List<Issue> bProjectIssues = new ArrayList<Issue>();

            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "12345678");
            provider.setCredentials(AuthScope.ANY, credentials);

            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10 * 1000).build();

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .setDefaultRequestConfig(requestConfig)
                    .build();

            for (Project project : projects) {
                if (projectPairRepository.existsByAid(project.getID()) && project.getSystemid() == 1) {
                    HttpGet getAIssuesRequest = new HttpGet("http://localhost:3000/issues.json?project_id=" + project.getRedmineid());
                    HttpResponse response = client.execute(getAIssuesRequest);

                    int statusCode = response.getStatusLine().getStatusCode();

                    HttpEntity entity = response.getEntity();

                    JSONObject myObject = new JSONObject(EntityUtils.toString(entity));

                    List<RedIssueOriginal> redmineIssueList = objectMapper.readValue(myObject.getString("issues"), new TypeReference<List<RedIssueOriginal>>() {
                    });


                    for (RedIssueOriginal redmineIssue : redmineIssueList) {
                        if(redmineIssue.getAssigned_to() != null){
                            Issue issue = new Issue(redmineIssue.getId(),redmineIssue.getTracker().getId(),redmineIssue.getSubject(),
                                    redmineIssue.getAssigned_to().getId(),redmineIssue.getStatus().getId(),
                                    redmineIssue.getPriority().getId(), 1, redmineIssue.getProject().getID());
                            aProjectIssues.add(issue);
                        } else {
                            Issue issue = new Issue(redmineIssue.getId(),redmineIssue.getTracker().getId(),redmineIssue.getSubject(), redmineIssue.getStatus().getId(),
                                    redmineIssue.getPriority().getId(), 1, redmineIssue.getProject().getID());
                            aProjectIssues.add(issue);
                        }
                    }
                    getAIssuesRequest.releaseConnection();
                }
            }

            for (Project project : projects) {
                if (project.getSystemid() == 2) {
                    HttpGet getBIssues = new HttpGet("http://localhost:3010/issues.json?project_id=" + project.getRedmineid());
                    HttpResponse response = client.execute(getBIssues);

                    int statusCode = response.getStatusLine().getStatusCode();

                    HttpEntity entity = response.getEntity();

                    JSONObject myObject = new JSONObject(EntityUtils.toString(entity));

                    List<RedIssueOriginal> redmineIssueList = objectMapper.readValue(myObject.getString("issues"), new TypeReference<List<RedIssueOriginal>>() {
                    });


                    for (RedIssueOriginal redmineIssue : redmineIssueList) {
                        if(redmineIssue.getAssigned_to() != null){
                            Issue issue = new Issue(redmineIssue.getId(),redmineIssue.getTracker().getId(),redmineIssue.getSubject(),
                                    redmineIssue.getAssigned_to().getId(),redmineIssue.getStatus().getId(),
                                    redmineIssue.getPriority().getId(), 2, redmineIssue.getProject().getID());
                            bProjectIssues.add(issue);
                        } else {
                            Issue issue = new Issue(redmineIssue.getId(),redmineIssue.getTracker().getId(),redmineIssue.getSubject(), redmineIssue.getStatus().getId(),
                                    redmineIssue.getPriority().getId(), 2, redmineIssue.getProject().getID());
                            bProjectIssues.add(issue);
                        }
                    }
                    getBIssues.releaseConnection();
                }
            }


            for (Issue aIssue : aProjectIssues){
                String hashedId = "(#"+ aIssue.getId() + ")";
                Issue foundBIssue = bProjectIssues.stream()
                        .filter(issue -> issue.getSubject().contains(hashedId))
                        .findFirst()
                        .orElse(null);
                if(foundBIssue == null) {
                    logger.debug("eljutottam ide");
                    SystemUser aUser = systemUsers.stream()
                            .filter(user -> user.getRedmineid() == aIssue.getAssigned_to() && user.getSystemid() == 1)
                            .findFirst()
                            .orElse(null);
                    String assignedTo = "";
                    SystemUserPair userPair = null;
                    if(aUser != null) {
                        userPair = userPairs.stream().filter(pair -> pair.getAId() == aUser.getId()).findFirst().orElse(null);
                    }
                    if(userPair != null) {
                        SystemUserPair finalUserPair = userPair;
                        SystemUser otherUser = systemUsers.stream().filter(user -> user.getId() == finalUserPair.getBId()).findFirst().orElse(null);
                        if (otherUser != null) {
                            assignedTo = ",\"assigned_to_id\":" + otherUser.getRedmineid();
                        }
                    }

                    Project bProject = null;
                    Project aProject = projects.stream().filter(project -> project.getRedmineid() == aIssue.getProjectid() && project.getSystemid() == 1)
                            .findFirst().orElse(null);
                    ProjectPair projectPair = null;
                    if(aProject != null) {
                        projectPair = projectPairs.stream().filter(pair -> pair.getAid() == aProject.getID()).findFirst().orElse(null);
                    }
                    if(projectPair != null) {
                        ProjectPair finalProjectPair = projectPair;
                        Project otherProject = projects.stream().filter(project -> project.getID() == finalProjectPair.getBid()).findFirst().orElse(null);
                        if (otherProject != null) {
                            bProject = otherProject;
                        }
                    }

                    if(bProject != null){
                        HttpPost request = new HttpPost("http://localhost:3010/issues.json");
                        String json = "{ \"issue\": {\"project_id\":" + bProject.getRedmineid() + ",\"subject\":\"" + aIssue.getSubject() +
                                "(#" + aIssue.getId() + ")" +"\"" + assignedTo + "} }";
                        StringEntity entity = new StringEntity(json);
                        request.setEntity(entity);
                        request.setHeader("Accept", "application/json");
                        request.setHeader("Content-type", "application/json");
                        HttpResponse post = client.execute(request);
                        request.releaseConnection();
                        logger.debug(post);
                    }
                }
            }
        }
        catch(IOException | JSONException e){
            logger.error(e);
        }
        return "ok";
    }
}
