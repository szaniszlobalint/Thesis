package com.redmine.application.redmineA.repositories;

import com.redmine.application.redmineA.entities.ARedmineUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AUserRepository extends CrudRepository<ARedmineUser,Long> {

}
