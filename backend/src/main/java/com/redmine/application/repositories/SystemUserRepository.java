package com.redmine.application.repositories;

import com.redmine.application.entities.System_User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<System_User, Long> {}
