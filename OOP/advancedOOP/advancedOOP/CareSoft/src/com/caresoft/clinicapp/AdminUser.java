package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser,HIPAACompliantAdmin {
	public AdminUser(int ID) {
		super(ID);
		// TODO Auto-generated constructor stub
	}
	// Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents= new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(int id,String role) {
    	super(id);
    	this.employeeID=id;
    	this.role=role;
    }

    
    public void newIncident(String notes) {
    	Date date= new Date(employeeID);
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            date, this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
    	Date date= new Date(employeeID);
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            date, this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int count=0;
		while(pin>0) {
			count++;
			pin=pin/10;
		}
		if(count>=6) {
			return true;
		}
		else {
			return false;

		}
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id==confirmedAuthID) {
			return true;
		}
		else {
			authIncident() ;
			return false;
		}
		
	}
    
    // TO DO: Setters & Getters
}
