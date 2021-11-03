package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.System_User_Pair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserPairRepository extends CrudRepository<System_User_Pair, Long> {

    boolean existsByAuserid(long num);
    boolean existsByBuserid(long num);
    System_User_Pair findByAuserid(long num);
    System_User_Pair findByBuserid(long num);
}
