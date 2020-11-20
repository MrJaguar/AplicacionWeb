package com.web.app.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MayorDeEdadValidator implements ConstraintValidator<MayorDeEdad, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value != null && value >= 18;
	}

}
