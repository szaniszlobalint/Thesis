package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {
    boolean existsByLoginAndSystemid(String login, long systemid);




}
