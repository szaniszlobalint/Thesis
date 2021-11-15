package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.StoredSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends CrudRepository<StoredSystem, Long> {}