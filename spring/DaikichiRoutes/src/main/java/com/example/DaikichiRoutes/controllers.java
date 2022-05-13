package com.example.DaikichiRoutes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class controllers {
 @RequestMapping(value="/daikichi")
 public String show() {
     return "Welcome!";
 }
 @RequestMapping(value="/daikichi/today")
 public String show1() {
     return "Today you will find luck in all your endeavors!";
 }
 @RequestMapping(value="/daikichi/tomorrow")
 public String show2() {
     return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
 }
}
