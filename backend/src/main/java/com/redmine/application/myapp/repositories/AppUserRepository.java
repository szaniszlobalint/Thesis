package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.App_User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<App_User, Long> {

    App_User findByUsername(String username);

}
