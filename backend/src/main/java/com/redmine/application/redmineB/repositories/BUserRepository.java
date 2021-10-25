package com.redmine.application.redmineB.repositories;

import com.redmine.application.redmineB.entities.BRedmineUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BUserRepository extends CrudRepository<BRedmineUser,Long> {

}