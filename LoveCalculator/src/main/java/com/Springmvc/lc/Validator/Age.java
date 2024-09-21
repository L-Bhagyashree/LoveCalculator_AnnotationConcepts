package com.Springmvc.lc.Validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy=AgeValidator.class)
public @interface Age {
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	//setting the user provided value to lower and upper so now the lower=30 and upper =70 previously lower=18 and upper =60 
	
	String message() default "{invalidAgeMessage}";
	int lower() default 18;
	int upper() default 60;

}
