package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.ProjectPair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPairRepository extends CrudRepository<ProjectPair, Long> {}
