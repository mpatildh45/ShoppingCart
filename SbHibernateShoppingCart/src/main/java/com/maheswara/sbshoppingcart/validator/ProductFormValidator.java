package com.maheswara.sbshoppingcart.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.maheswara.sbshoppingcart.dao.ProductDAO;
import com.maheswara.sbshoppingcart.entity.Product;
import com.maheswara.sbshoppingcart.form.ProductForm;

@Component
public class ProductFormValidator implements Validator {

	@Autowired
	private ProductDAO productDAO;
	
	//this validator only checks for the ProductForm
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == ProductForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {

		ProductForm productForm = (ProductForm) target;
		
		//checks the fields of ProductForm
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");

		String code = productForm.getCode();
		if(code != null && code.length() > 0) {
			if(code.matches("\\s+")) {
				errors.rejectValue("code", "Pattern.productForm.code");
			}else if(productForm.isNewProduct()) {
				Product product = productDAO.findProduct(code);
				if(product != null) {
					errors.rejectValue("code", "Duplicate.productForm.code");
				}
			}	
		}
	}

}
