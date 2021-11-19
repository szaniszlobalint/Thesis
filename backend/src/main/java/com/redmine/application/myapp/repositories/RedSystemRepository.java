package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.RedSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedSystemRepository extends CrudRepository<RedSystem, Long> {}