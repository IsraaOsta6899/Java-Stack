package com.example.projectmanager.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.example.projectmanager.models.LoginUser;
import com.example.projectmanager.models.Project;
import com.example.projectmanager.models.User;
import com.example.projectmanager.service.ProjectService;
import com.example.projectmanager.service.UserService;

//.. don't forget to inlcude all your imports! ..

@Controller
public class HomeController {
	private static UserService userService;
	private static ProjectService projectService;

	public HomeController(UserService userService,ProjectService projectService) {
		this.userService=userService;
		this.projectService=projectService;
	}

 
 @GetMapping("/")
 public String index(Model model ) {
	 
	 User newUser = new User();
	 LoginUser newLogin= new LoginUser();
     model.addAttribute("newUser", newUser);
     model.addAttribute("newLogin",newLogin);
     return "index.jsp";
 }

 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {

     if(result.hasErrors()) {

         model.addAttribute("newUser", newUser);

         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
	 this.userService.register(newUser, result);

 
     return "redirect:/";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
      User user = this.userService.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "index.jsp";
     }
 
     session.setAttribute("user", user);
     return "redirect:/home";
 }
 @GetMapping("/home")
 public String home( HttpSession session, Model model) {
	 User user= new User();
	 user=(User) session.getAttribute("user");
	 List<Project>projects=projectService.notIncLudedProjects(user);
	 for (Project project : projects) {
		System.out.println(project.getTitle());
	}
	 List<Project>yourprojects=projectService.yourProjects(user);
	
	 model.addAttribute("user", user);

	 model.addAttribute("projects", projects);
	 model.addAttribute("yourprojects", yourprojects);

	 return "Home.jsp";
 }
 @GetMapping("/projects/new")
 public String create( HttpSession session, Model model,@ModelAttribute("project")Project project) {
	 User user= (User) session.getAttribute("user");
Project project1= project;	 
model.addAttribute("project", project);

	 return "newProject.jsp";
 }
 
 @PostMapping("/projects/new")
 public String addProject( HttpSession session, Model model,@ModelAttribute("project") Project project) {
	User user= (User) session.getAttribute("user");
	Project newProject= project;
	newProject.setOwner(user);

	List<User>allWorkingUsers = new ArrayList<User>() ;
	allWorkingUsers.add(user);
	
	newProject.setUsers(allWorkingUsers);
	projectService.addProject(newProject);
	List<Project>ownProjects=   user.getOwnsprojects();
	ownProjects.add(newProject);
	user.setOwnsprojects(ownProjects);
	 List<Project>projects= user.getProjects();
	 projects.add(newProject);
	 user.setProjects(projects);
	 userService.updateUser(user);
	 
	
	
		 return "redirect:/home";
 }
 
 @RequestMapping("/users/join/{id}")
 public String joinProjectTeam(@PathVariable("id")Long projectId,HttpSession session) {
		User user= (User) session.getAttribute("user");
		List<Project>yourProjects=user.getProjects();
		Optional<Project> p=projectService.getProjectPyId(projectId);
		Project newProject=p.get();
		yourProjects.add(newProject);
		user.setProjects(yourProjects);
		userService.updateUser(user);
		List<User>users=newProject.getUsers();
		users.add(user);
		newProject.setUsers(users);
		projectService.updateProject(newProject);
		return "redirect:/home";
 }
 
 @RequestMapping("/users/leave/{id}")
 public String leaveProjectTeam(@PathVariable("id")Long projectId,HttpSession session) {
		User user= (User) session.getAttribute("user");
		List<Project>yourProjects=user.getProjects();
		Optional<Project> p=projectService.getProjectPyId(projectId);
		Project newProject=p.get();
		for(int i=0;i<yourProjects.size();i++) {
			if(yourProjects.get(i).getId()==newProject.getId()) {
				yourProjects.remove(i);
			}
		}
		user.setProjects(yourProjects);
		userService.updateUser(user);
		
		List<User>projectTeamList=   newProject.getUsers();
		for(int i=0;i<projectTeamList.size();i++) {
			if(projectTeamList.get(i).getId()==user.getId() ) {
				projectTeamList.remove(i);
			}
		}
		newProject.setUsers(projectTeamList);
		projectService.updateProject(newProject)	;
		return "redirect:/home";
 }
 @GetMapping("/projects/{id}")
 public String showProject(@PathVariable("id")Long projectId,Model model) {
	 Optional<Project> project= projectService.getProjectPyId(projectId);
	 Project project2 =project.get();
	 model.addAttribute("project", project2);
	 return "showProject.jsp";
 }
 @RequestMapping("/projects/delete/{id}")
 public String deleteProject(@PathVariable("id")Long projectID) {
	 Optional<Project> project= projectService.getProjectPyId(projectID);
	 Project project2 =project.get();
	 projectService.deleteProject(project2);
	 return "redirect:/home";
 }
 @GetMapping("/projects/edit/{id}")
 public String editPage(@PathVariable("id")Long projectID,@ModelAttribute("project")Project project,HttpSession session,Model model){
	 Optional<Project> project1= projectService.getProjectPyId(projectID);
	 Project project2 =project1.get();
	 model.addAttribute("project", project2);
	 return "editProject.jsp";
 }
 @PostMapping("/projects/edit/{id}")
 public String editProject(@PathVariable("id")Long projectID,@ModelAttribute("project")Project project,HttpSession session,Model model){
	 Optional<Project> project1= projectService.getProjectPyId(projectID);
	 Project project2 =project1.get();
	 project2.setTitle(project.getTitle());
	 project2.setDescription(project.getDescription());
	 project2.setDuedate(project.getDuedate());
	 projectService.updateProject(project2);
	 return "redirect:/home";
 } 
 
 

}

