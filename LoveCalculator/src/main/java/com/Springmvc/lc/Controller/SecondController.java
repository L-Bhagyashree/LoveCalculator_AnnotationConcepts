package com.Springmvc.lc.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SecondController {

	@RequestMapping("/normalMethod")
	public String handleNormalMethod( Model model, HttpSession session) {
		
		//retrieving objects from session attribute
		String address=(String)session.getAttribute("address");
		//manipulating address
		String newAddress=address+"Odisha";
		//saving the new address as address to model attribute
		model.addAttribute("address", newAddress);
		
		
		/*
		 * @SessionAttribute("FirstName") String Name 
		 * Fetching value of FirstName from session scope and adding it to name variable
		 * System.out.println("inside new controller method, printing name:" + Name);
		 * updating / manipulating name and storing it in newFname
		 * String newFname = "Mr." + Name; 
		 * adding the newFname to model attribute as FirstName
		 * model.addAttribute("FirstName", newFname); 
		 */
		session.invalidate();
		return "index";
		/*
		 * 
		 * String name=(String)model.getAttribute("FirstName");
		 * System.out.println("inside new controller method, printing name:"+name);
		 * String name=(String)model.getAttribute("name");
		 * System.out.println("inside new controller method, printing name:"+name);
		 * here we are getting name as null as it is a different controller which is
		 * outside of the first controller. so the session Scope is not sending the
		 * object name and surname to model/request scope of this secondController and
		 * request scope is empty here.but in index page we're getting the value. The
		 * index page fetching value from session scope so we are getting value of
		 * name/surname as the index page will search for the variables .in model scope
		 * first the it will look inside the session scope for values
		 */

	}
}
