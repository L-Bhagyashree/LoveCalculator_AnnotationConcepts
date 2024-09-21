package com.Springmvc.lc.Service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {

	public final String LC_App_Formula="FLAME";
	@Override
	public String calculateLove(String userName, String crushName) {
		// TODO Auto-generated method stub
		
		int userAndCrushNameCount=(userName+crushName).toCharArray().length;
		
		int formulaCount=LC_App_Formula.toCharArray().length;
		int rem=userAndCrushNameCount%formulaCount;
		System.out.println(rem+"is rem"+userAndCrushNameCount+"is userAndCrushNameCount"+formulaCount+"is formulaCount ");
		char reusltChar=LC_App_Formula.charAt(rem);
		System.out.println("result char"+reusltChar);
		String result= WhatsBetweenUs(reusltChar);
		System.out.println("character  is"+result);
		
		return result;
	}
	@Override
	public String WhatsBetweenUs(char calculationResult) {
		// TODO Auto-generated method stub
		
		String result=null;
		System.out.println("calculationResult character  is"+calculationResult);
		
		if(calculationResult=='F') {
			result= LoveCalculatorConstants.F_CHAR_MEANING;
		}
		
		else if(calculationResult=='L') {
			result= LoveCalculatorConstants.L_CHAR_MEANING;
		}
		
		else if(calculationResult=='A') {
			result= LoveCalculatorConstants.A_CHAR_MEANING;
		}
		
		else if(calculationResult=='M') {
			result= LoveCalculatorConstants.M_CHAR_MEANING;
		}
		
		else if(calculationResult=='E') {
			result= LoveCalculatorConstants.E_CHAR_MEANING;
		}
		
		else if(calculationResult=='S') {
			result= LoveCalculatorConstants.S_CHAR_MEANING;
		}
			
		return result;
	}

}
