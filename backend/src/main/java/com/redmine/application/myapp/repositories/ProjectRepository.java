package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.Project;
import com.redmine.application.myapp.entities.ProjectPair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    boolean existsByNameAndSystemid(String login, long systemid);

    @Query("SELECT p FROM Project p WHERE p.systemid = :num AND p.ID IN (SELECT pp.aid FROM ProjectPair pp)")
    List<Project> getAProjects(@Param("num") long num);

    List<Project> findAllBySystemid(long num);




}
