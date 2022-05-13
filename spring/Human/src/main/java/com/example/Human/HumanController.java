package com.example.Human; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	 @RequestMapping(value="/")
	 public String index() {
		 return "Hello Human";
	 }

	 @RequestMapping("/{name}")
	    public String index2(@PathVariable("name") String name){
	    	return "hello "+name;
	    }
	 @RequestMapping("/{name}/{lastName}")
	    public String index3(@PathVariable("name") String name,@PathVariable("lastName")String lName){
	    	return "hello "+name+" "+lName;
	    }
}
