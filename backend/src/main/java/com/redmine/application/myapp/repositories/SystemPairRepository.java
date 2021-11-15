package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.SystemPair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemPairRepository extends CrudRepository<SystemPair, Long> {}
