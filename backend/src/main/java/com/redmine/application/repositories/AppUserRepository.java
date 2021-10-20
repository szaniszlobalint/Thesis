package com.redmine.application.repositories;

import com.redmine.application.entities.App_User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<App_User, Long> {

    App_User findByUsername(String username);

}
