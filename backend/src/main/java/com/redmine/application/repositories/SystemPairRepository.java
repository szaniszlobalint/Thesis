package com.redmine.application.repositories;

import com.redmine.application.entities.System_Pair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemPairRepository extends CrudRepository<System_Pair, Long> {}
