package com.redmine.application.repositories;

import com.redmine.application.entities.Stored_System;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends CrudRepository<Stored_System, Long> {}