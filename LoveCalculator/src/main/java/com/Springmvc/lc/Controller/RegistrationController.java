package com.Springmvc.lc.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Springmvc.lc.Propertyeditor.NameEditor;
import com.Springmvc.lc.api.CommunicationDTO;
import com.Springmvc.lc.api.Phone;
import com.Springmvc.lc.api.UserRegistrationDTO;

@Controller
public class RegistrationController {
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("user") UserRegistrationDTO dto) {
		
		dto.setName("Abhi");
		Phone phone=new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("256761278");
		
		CommunicationDTO communicationDTO=new CommunicationDTO();
		communicationDTO.setPhone(phone);
		dto.setCommunicationDTO(communicationDTO);
		
		System.out.println(phone);
		System.out.println("inside show registartion page");
		return "registration";
	}
	
	
	@RequestMapping("/registration-success")
	public String processUserReg( @Valid @ModelAttribute("user") UserRegistrationDTO userDto, BindingResult result) {
		System.out.println("The name user has entered is"+"|"+userDto.getName()+"|");
		
		if(result.hasErrors()) {
			System.out.println("My page has errors");
			List<ObjectError> allErrors = result.getAllErrors();
			
			for(ObjectError error:allErrors) {
				System.out.println(error);
			}
			return "registration";
			
		}
		
		System.out.println("inside registration success page");
		
		return "registration-success";
	}
	
	
	// it will get excuted first when we will hit /register 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside the init Binder method");
		
		//binder.setDisallowedFields("userName");
		
		StringTrimmerEditor editor=new StringTrimmerEditor(false);
		binder.registerCustomEditor(String.class,"name", editor);
		
		NameEditor nameEditor=new NameEditor();
		//binder.registerCustomEditor(String.class,"name",nameEditor );
		binder.registerCustomEditor(String.class,nameEditor );
	}
	
	
}
