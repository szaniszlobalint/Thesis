package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.Project_Pair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPairRepository extends CrudRepository<Project_Pair, Long> {}
