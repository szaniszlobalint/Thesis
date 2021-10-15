package com.redmine.application.repositories;

import com.redmine.application.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {}
