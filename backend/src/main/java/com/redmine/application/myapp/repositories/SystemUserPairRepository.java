package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.SystemUserPair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserPairRepository extends CrudRepository<SystemUserPair, Long> {

    boolean existsByAid(long num);
    boolean existsByBid(long num);
    SystemUserPair findByAid(long num);
    SystemUserPair findByBid(long num);
    SystemUserPair findByAidAndBid(long num1, long num2);
}
