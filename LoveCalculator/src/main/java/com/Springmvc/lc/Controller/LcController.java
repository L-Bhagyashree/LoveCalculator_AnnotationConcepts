package com.Springmvc.lc.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Springmvc.lc.Service.LCAppService;
import com.Springmvc.lc.api.UserInfoDTO;

@Controller
@SessionAttributes("user")
public class LcController {
	
	@Autowired
	private LCAppService lcAppService;
	
	//reading the property by fetching it from url
	
	@GetMapping("/")
	public String Homepage( Model model) {
		
		model.addAttribute("user", new UserInfoDTO());
		//FOR fetching the value from session and displaying during the next login||SESSION IMPLEMENTATION||
		
		/*
		 * public String Homepage(@ModelAttribute("user") UserInfoDTO
		 * userInfoDTO,HttpSession session) {
		 * 
		 * 
		 * String myUserName=(String) session.getAttribute("userName");
		 * userInfoDTO.setUserName(myUserName);
		 */
		
		
		/*
		 * public String Homepage(Model model) UserInfoDTO userInfoDTO=new
		 * UserInfoDTO(); model.addAttribute("user",userInfoDTO);
		 */
		//FOR COOKIES FOLLOW THIS APPROACH
		/*
		 * public String Homepage(@ModelAttribute("user") UserInfoDTO userInfoDTO, HttpServletRequest request)
		 * Cookie[] cookies=request.getCookies(); for(Cookie temp: cookies) {
		 * if("lcApp.userName".equals(temp.getName())) {
		 * 
		 * String myUserName=temp.getValue(); userInfoDTO.setUserName(myUserName); } }
		 */
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	public String showResultPage(Model model, @Valid  UserInfoDTO userInfoDTO, BindingResult result) {
		
		model.addAttribute("user", userInfoDTO);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"user",result);
		//FOR COOKIES FOLLOW THIS APPROACH
		//cookie declaration
		//public String showResultPage(@Valid @ModelAttribute("user") UserInfoDTO userInfoDTO, BindingResult result,Model model)
		/*
		 * public String showResultPage(@Valid @ModelAttribute("user") UserInfoDTO userInfoDTO, 
		 * BindingResult result, HttpServletResponse response) {
		
		 * Cookie theCookie= new Cookie("lcApp.userName",userInfoDTO.getUserName());
		 * theCookie.setMaxAge(60*60*24);
		 * 
		 * //register the cookie response.addCookie(theCookie);
		 */
		
		/*
		 * public String showResultPage(@RequestParam String
		 * userName, @RequestParam("crushName") String crushName1, Model model)
		 * System.out.println("User Name:"+ userName); System.out.println("Crush Name:"+
		 * crushName1); model.addAttribute("userName",userName);
		 * model.addAttribute("crushName",crushName1);
		 */

		//writing the property by fetching it from url
		/*
		 * public String showResultPage(UserInfoDTO userInfoDTO, Model model)
		 * model.addAttribute("userName", userInfoDTO.getUserName());
		 * model.addAttribute("crushName",userInfoDTO.getCrushName());
		 * System.out.println("User Name:" + userInfoDTO.getUserName());
		 * System.out.println("Crush Name:" + userInfoDTO.getCrushName());
		 */
		
		//||SESSION IMPLEMENTATION WITHOUT @SESSIONATTRIBUTES||
		
		/*
		 * public String showResultPage(@Valid @ModelAttribute("user") UserInfoDTO
		 * userInfoDTO, BindingResult result, HttpServletRequest request) HttpSession
		 * session=request.getSession(); session.setAttribute("userName",
		 * userInfoDTO.getUserName()); session.setMaxInactiveInterval(120);
		 */
		//if the user remains inactive for 120 minutes remove the userName object from the session.
		
		
		System.out.println(userInfoDTO.isTermAndCondition());
		
		System.out.println("inside the process homepage");
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors=result.getAllErrors();
			for(ObjectError temp: allErrors ) {
				System.out.println(temp);
			}		
			return "home-page";
		}
		
		//write a service which will calculate the love % between user and crush
		
		String appResult=lcAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
		//model.addAttribute("AppResult", appResult);
		userInfoDTO.setAppResult(appResult);
		System.out.println(appResult);
		return "result-page";
		
		
		
	}
}
