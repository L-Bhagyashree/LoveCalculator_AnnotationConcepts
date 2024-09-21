package com.Springmvc.lc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes({"FirstName", "LastName"})
public class FirstController {
	
	@GetMapping("/first")
	public String handleFirst( Model model, HttpServletRequest request) {
		
		model.addAttribute("FirstName", "Bhagyashree");
		model.addAttribute("LastName", "Mohanty");
		model.addAttribute("next", "/second");
		
		//it will store the object in http session storage
		HttpSession session=request.getSession();
		session.setAttribute("address","Blr");
		
		return "index";
	}
	@GetMapping("/second")
	public String handleSecond( Model model1) {
		
		/*These are unnecessary but still add it upto sysout, model1.addAttribute is unnecessary
		 * but for printing something in console we need it
		 * String FirstName=(String) model1.getAttribute("FirstName");
		 System.out.println(FirstName); 
		 model1.addAttribute("FirstName", FirstName);
		 */
		
		String FirstName=(String) model1.getAttribute("FirstName");
		String LastName=(String) model1.getAttribute("LastName");
		 System.out.println("inside second"+FirstName); 
		 System.out.println("inside second"+LastName); 
		 
		 
		
		 model1.addAttribute("next", "/third");
		 
		return "index";
	}
	
	@GetMapping("/third")
	public String handleThird( Model model, SessionStatus status, HttpSession session) {
		
		/*These are unnecessary but still add it upto sysout, model1.addAttribute is unnecessary
		 * String FirstName=(String) model1.getAttribute("FirstName");
		 * System.out.println(FirstName); model1.addAttribute("FirstName", FirstName);
		 */
		String FirstName=(String) model.getAttribute("FirstName");
		 System.out.println("inside third"+FirstName); 
		 
		 status.setComplete();
		 
		 String address =(String)session.getAttribute("address");
		 String newAddress=address+"Home Sweet Home";
		 model.addAttribute("address", newAddress);
		
		return "index";
	}
	

}
