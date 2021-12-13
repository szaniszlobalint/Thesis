package com.redmine.application.myapp.repositories;

import com.redmine.application.myapp.entities.ProjectPair;
import com.redmine.application.myapp.entities.SystemUserPair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectPairRepository extends CrudRepository<ProjectPair, Long> {
    boolean existsByAid(long num1);
    ProjectPair findByAidAndBid(long num1, long num2);
    @Query("SELECT p.aid FROM ProjectPair p")
    List<Long> findAllAProjects();

}
