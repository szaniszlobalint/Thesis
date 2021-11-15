package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.SystemUserPair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserPairRepository extends CrudRepository<SystemUserPair, Long> {

    boolean existsByAuserid(long num);
    boolean existsByBuserid(long num);
    SystemUserPair findByAuserid(long num);
    SystemUserPair findByBuserid(long num);
    SystemUserPair findByAuseridAndBuserid(long num1, long num2);

}
