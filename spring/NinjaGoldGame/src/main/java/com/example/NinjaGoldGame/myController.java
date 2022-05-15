package com.example.NinjaGoldGame;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class myController {
	@GetMapping(value="/")
	 public String show(Model m,HttpSession session) {
		if(session.getAttribute("total")==null) {
			session.setAttribute("total", "you did not earn nothing until now");
		}
		m.addAttribute("total", session.getAttribute("total"));
		 return "Index.jsp";
	  }
	@PostMapping(value="/process_money/{s}")
	public String calculate(@PathVariable("s")String s,HttpSession session,Model model ) {
		if(s.equalsIgnoreCase("Farm")) {

			if (session.getAttribute("Farm") == null) {
				session.setAttribute("Farm", 0);	
				}
			else {
				Integer currentCount = (Integer) session.getAttribute("Farm");
				Random random=new Random();
				int c=random.nextInt(10, 20);
				currentCount=currentCount+c;
				session.setAttribute("Farm", currentCount);
			}
		}
		else if(s.equalsIgnoreCase("Cave")) {
			if (session.getAttribute("Cave") == null) {
				session.setAttribute("Cave", 0);	
				}
			else {
				Integer currentCount = (Integer) session.getAttribute("Cave");
				Random random=new Random();
				int c=random.nextInt(5, 10);
				currentCount=currentCount+c;
				session.setAttribute("Cave", currentCount);
			}
			
		}
		else if(s.equalsIgnoreCase("House")) {
			if (session.getAttribute("House") == null) {
				session.setAttribute("House", 0);	
				}
			else {
				Integer currentCount = (Integer) session.getAttribute("House");
				Random random=new Random();
				int c=random.nextInt(2, 5);
				currentCount=currentCount+c;
				session.setAttribute("House", currentCount);
			}
		}
		else {
			if (session.getAttribute("Casino") == null) {
			session.setAttribute("Casino", 0);	
			}
		else {
			Integer currentCount = (Integer) session.getAttribute("Casino");
			Random random=new Random();
			Random random2=new Random();
			int c2=random2.nextInt(-2, 2);
			if(c2>0) {
				int c=random.nextInt(0, 50);
				currentCount=currentCount+c;
				session.setAttribute("Casino", currentCount);
			}
			else {
				int c=random.nextInt(-50, 0);
				currentCount=currentCount+c;
				session.setAttribute("Casino", currentCount);
			}
			
		}
		}
		if (session.getAttribute("total") == null) {
			session.setAttribute("total", "until now you did not earn anything");	
			}
		else {
		
			session.setAttribute("total", "until now you  earn "+session.getAttribute("Casino")+"  from casino \n"+session.getAttribute("Farm")+"  from Farm \n"+session.getAttribute("Cave")+"   from Cave \n"+session.getAttribute("House")+"  from House \n");	
		}



		return "redirect:/";
    }
	
	
}
