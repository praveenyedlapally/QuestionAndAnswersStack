package com.qc.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qc.user.Questions;

public class CustomValidator implements Validator{

	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Questions.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
		     "required.address", "Field name is required.");
		
	}
}