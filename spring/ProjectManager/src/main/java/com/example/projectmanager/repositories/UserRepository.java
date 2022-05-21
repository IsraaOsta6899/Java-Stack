package com.example.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.projectmanager.models.Project;
import com.example.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    List<User> findAllByProjects(Project priject);

    List<User> findByProjectsNotContains(Project priject);
    
}
