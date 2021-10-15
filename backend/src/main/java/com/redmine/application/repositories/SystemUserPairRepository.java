package com.redmine.application.repositories;

import com.redmine.application.entities.System_User_Pair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserPairRepository extends CrudRepository<System_User_Pair, Long> {}
