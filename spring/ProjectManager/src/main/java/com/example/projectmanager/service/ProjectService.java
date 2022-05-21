package com.example.projectmanager.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.projectmanager.models.Project;
import com.example.projectmanager.models.User;
import com.example.projectmanager.repositories.ProjectRepository;
@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository=projectRepository;
		
	}
	
	public List<Project>getAllProjects(){
		return projectRepository.findAll();
	}
	public List<Project>notIncLudedProjects(User user){
		return projectRepository.findByUsersNotContains(user);
	}
	public List<Project>yourProjects(User user){
		return projectRepository.findAllByUsers(user);
	}
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}
	public Optional<Project> getProjectPyId(Long id) {
		return projectRepository.findById(id);
	}
	public Project updateProject(Project project) {
		Project p=projectRepository.save(project);
		return p;
	}
	public void deleteProject(Project project) {
		projectRepository.delete(project);
		return;
	}
	

}
