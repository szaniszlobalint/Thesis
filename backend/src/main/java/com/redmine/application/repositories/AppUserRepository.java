package com.redmine.application.repositories;

import com.redmine.application.entities.App_User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<App_User, Long> {}
