package com.example.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.projectmanager.models.*;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	Optional<Project> findById(Long id);
	List<Project>findAll();
    List<Project> findAllByUsers(User user);

    List<Project> findByUsersNotContains(User user);

}
