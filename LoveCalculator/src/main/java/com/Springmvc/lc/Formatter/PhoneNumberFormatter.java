package com.Springmvc.lc.Formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.Springmvc.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		// TODO Auto-generated method stub
		//for reverse binding i.e. to show default value inside phone number field
		
		System.out.println("inside the print method of PhoneNumberFormatter");
		
		return phone.getCountryCode()+"-"+phone.getUserNumber();		
		
	}

	@Override
	public Phone parse(String  completePhoneNumber, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("inside the parse method of PhoneNumberFormatter");
		Phone phone=new Phone();
		
		//split the string received from the user
		String[] phoneNumberArray=completePhoneNumber.split("-");
		
		//whether the number consists of -
		int index=completePhoneNumber.indexOf('-');
		if(index==-1 || completePhoneNumber.startsWith("-") ) {
			
			//if the '-' is not found, then add 91 as the default country code
			phone.setCountryCode("91");
			if(completePhoneNumber.startsWith("-") ) {
				phone.setUserNumber(phoneNumberArray[1]);
			}
			else {
				phone.setUserNumber(phoneNumberArray[0]);
			}
			
		}
		
		
		else {
			
			
			
			//extract the country code and set it to the phone class  country CodeProperty
			
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		
		}
	
		
		
		return phone;
	}

}
