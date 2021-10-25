package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.Stored_System;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends CrudRepository<Stored_System, Long> {}