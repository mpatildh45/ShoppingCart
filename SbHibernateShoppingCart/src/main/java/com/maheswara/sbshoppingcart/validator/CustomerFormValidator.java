package com.maheswara.sbshoppingcart.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.maheswara.sbshoppingcart.form.CustomerForm;

@Component
public class CustomerFormValidator implements Validator {

	private EmailValidator emailValidator = EmailValidator.getInstance();
	
	//This Validator only checks for the customerForm.
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == CustomerForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerForm custInfo = (CustomerForm) target;
		
		//Check the Fields of CustomerForm
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");

	if(!emailValidator.isValid(custInfo.getEmail())) {
		errors.rejectValue("email", "Pattern.customerForm.email");
	}
  }
}