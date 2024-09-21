package com.Springmvc.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


//public class AgeValidator implements ConstraintValidator<Age,Integer> Age- annotaion name Integer -data type of annotation

public class AgeValidator implements ConstraintValidator<Age,Integer> {
	
	private int lower;
	private int upper;
	
	@Override	
	public void initialize(Age age) {
		
		//i can write the post construct work right here
		//it will copy the lower and upper from age class to local lower and upper variable
		this.lower=age.lower();
		this.upper=age.upper();
		
	}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		//validation logic
		
		if(age==null) {
			return false;
		}
		
		if(age<lower || age>upper) {
			return false;
			
		}
		
		
		
		return true;
	}

}
