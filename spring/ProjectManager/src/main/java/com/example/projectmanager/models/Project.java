package com.example.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="projects")
public class Project {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull
 @Size(min=3, max=30, message="title must be between 3 and 30 characters")
 private String title;
 @Size(min=3, max=30, message="description must be between 3 and 30 characters")

 private String description;
 
 private String duedate;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
@ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(
     name = "users_prjects", 
     joinColumns = @JoinColumn(name = "project_id"), 
     inverseJoinColumns = @JoinColumn(name = "user_id")
 )
 private List<User> users;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="user_id")
 private User owner;
 
 public Project() {
     
 }

public User getOwner() {
	return owner;
}

public void setOwner(User owner) {
	this.owner = owner;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getDuedate() {
	return duedate;
}

public void setDuedate(String duedate) {
	this.duedate = duedate;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public List<User> getUsers() {
	return users;
}

public void setUsers(List<User> users) {
	this.users = users;
}

}


