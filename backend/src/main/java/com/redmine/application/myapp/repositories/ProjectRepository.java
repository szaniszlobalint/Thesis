package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {}
