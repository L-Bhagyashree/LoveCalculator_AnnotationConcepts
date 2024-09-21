package com.Springmvc.lc.Controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.Springmvc.lc.Service.LCAppEmailService;
import com.Springmvc.lc.Service.LCAppEmailServiceImpl;
import com.Springmvc.lc.api.EmailDTO;
import com.Springmvc.lc.api.UserInfoDTO;

@Controller
public class EmailController {
	
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailServiceImpl;

	@RequestMapping("/sendEmail")
	public String sendEmail( Model model) {
		
		/*In case you are using path Variable
		 * @RequestMapping("/sendEmail/{userName}")
		 * @RequestMapping("/sendEmail/{userName}") public String
		 * sendEmail(@PathVariable("userName") String userName, Model model)
		 * model.addAttribute("userName", userName.toUpperCase());
		 */
		
		//FOR COOKIES FOLLOW THIS APPROACH
		/*
		 * public String sendEmail(@CookieValue("lcApp.userName") String userName, Model
		 * model) model.addAttribute("userName",userName );
		 */
		
		model.addAttribute("email", new EmailDTO());
		
		return "send-email-page";

	}
	 
	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("user") UserInfoDTO userInfoDTO, @ModelAttribute("email") EmailDTO emailDTO) {
		
		Logger logger=Logger.getLogger(EmailController.class.getName());
		
		try {
			

			lcAppEmailServiceImpl.sendEmail(userInfoDTO.getUserName(), emailDTO.getUserEmail(),"Friend");
		}
		catch(Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
		}
		
		//For SESSION IMPLEMENTATION
		/*
		 * //public String processEmail(@ModelAttribute("email") EmailDTO emailDTO,
		 * HttpSession session,Model model) String userName=(String)
		 * session.getAttribute("userName"); String newUserName="Mr."+userName;
		 * model.addAttribute("userName", newUserName);
		 */
		
		//FOR COOKIES FOLLOW THIS APPROACH
		
		/*
		 * public String processEmail(@ModelAttribute("email") EmailDTO
		 * emailDTO, @CookieValue("lcApp.userName") String userName,Model model) {
		 * 
		 * model.addAttribute("userName", userName);
		 */
		
		return "process-email-page";

	}
}
