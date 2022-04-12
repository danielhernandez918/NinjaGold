package com.daniel.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpSession;

//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class mainController {
	ArrayList<String> logs = new ArrayList<String>();
	@GetMapping("/Gold") 
    public String setCount(HttpSession session) {
		if (session.getAttribute("gold")==null) {
			session.setAttribute("gold",0);
		}
		if (session.getAttribute("log")==null) {
			session.setAttribute("log", new ArrayList<String>());
		}
		else {
			session.getAttribute("gold");
			session.getAttribute("log");

		}
        
		return "main.jsp";
	}
	@PostMapping("/Gold/process") 
    public String process( @RequestParam("location") String location, HttpSession session) {
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    String strDate= formatter.format(date);  
		Random rand = new Random(); //instance of random class
		Integer currGold = (Integer) session.getAttribute("gold");
		@SuppressWarnings("unchecked")
		ArrayList<String>goldLog = (ArrayList<String>)session.getAttribute("log");
		if(location.equals("farm")) {
			int upper = 11;
			int random = rand.nextInt(upper)+10;
			currGold+= random;
			session.setAttribute("gold",currGold);
			goldLog.add(String.format("You entered a farm and earned %s gold (%s)", random, strDate));

		}
		else if(location.equals("cave")) {
			int upper = 6;
			int random = rand.nextInt(upper)+5;
			currGold+= random;
			session.setAttribute("gold",currGold);
			goldLog.add(String.format("You entered a cave and earned %s gold (%s)", random, strDate));

		}
		else if(location.equals("house")) {
			int upper = 4;
			int random = rand.nextInt(upper)+2;
			currGold+= random;
			session.setAttribute("gold",currGold);
			goldLog.add(String.format("You entered a house and earned %s gold (%s)", random, strDate));

		}
		else if(location.equals("quest")) {
			int upper = 51;
			int posNeg = 2;
			int addRemove = rand.nextInt(posNeg);
			int random = rand.nextInt(upper);
			if(addRemove == 0) {
				currGold+= random;
				session.setAttribute("gold",currGold);
				goldLog.add(String.format("You completed a quest and earned %s gold (%s)", random, strDate));

			}
			else {
				currGold-= random;
				session.setAttribute("gold",currGold);
				goldLog.add(String.format("You failed a quest and lost %s gold (%s)", random, strDate));

			}
		}
		return "redirect:/Gold";

	}
    		
	
}