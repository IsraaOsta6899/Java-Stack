package com.example.Languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Languages")
public class Language {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @NotNull
	 @Size(min = 5, max = 200,message="it mustn't be empty")
	private String Name;
	 @NotNull
	 @Size(min = 5, max = 200,message="it mustn't be empty")
	private String Creator;
	 @NotNull
	 
	private double Version;
	 @Column(updatable=false)
     @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
     @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	public Language() {
		
	}
	public Language(String Name,String Creator,double Version) {
		this.Name=Name;
		this.Creator=Creator;
		this.Version=Version;
		
	}
		@PrePersist
	 	protected void onCreate(){
	        this.createdAt = new Date();
	    }
     	@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getCreator() {
			return Creator;
		}
		public void setCreator(String creator) {
			Creator = creator;
		}
		public double getVersion() {
			return Version;
		}
		public void setVersion(double version) {
			Version = version;
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
	

	
}
