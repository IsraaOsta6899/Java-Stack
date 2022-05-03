package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
	public Physician(int ID) {
		super(ID);
		this.id=ID;
	}

	// Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	@Override
	public boolean assignPin(int pin) {
		int count=0;
		while(pin>0) {
			count++;
			pin=pin/10;
		
		}
		if(count==4) {
			return true;
		}
		else {
			return false;

		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id==confirmedAuthID) 
			return true;
		else
			return false;
	}
	
    // TO DO: Setters & Getters
}
