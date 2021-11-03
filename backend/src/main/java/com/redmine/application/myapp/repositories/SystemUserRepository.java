package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.System_User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<System_User, Long> {
    boolean existsByLoginAndSystemid(String login, long systemid);




}
