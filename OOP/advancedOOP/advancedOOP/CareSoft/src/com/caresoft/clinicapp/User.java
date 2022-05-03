package com.caresoft.clinicapp;

public class User {
	protected Integer id;
    protected int pin;
	 public User(int ID) {
		 this.id=ID;
	 }
	 public void setId(Integer id) {
		 this.id=id;
	 }
	 public void setPin(int pin) {
		 this.pin=pin;
	 }
	 public int getPin() {
		 return this.pin;
	 }
	 public int getId() {
		 return this.id;
	 }
}
