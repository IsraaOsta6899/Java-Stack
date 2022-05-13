package com.example.DaikichiPathVariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	 @RequestMapping(value="/daikichi/travel/honolulu")
	 public String index() {
		 return "Congratulation ! you will soon travel to honolulu";
	 }

	 @RequestMapping("/daikichi/lotto/{number}")
	    public String index2(@PathVariable("number") Integer num){
	    	if(num%2 ==0) {
	    		return "'You will take a grand journey in the near future, but be weary of tempting offers";
	    	}
	    	else return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	    }
	 
}