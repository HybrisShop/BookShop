/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.smarteditwebservices.validation.facade;

import org.springframework.validation.Validator;


/**
 * Service used to perform validation in the facade.
 */
public interface FacadeValidationService
{
	/**
	 * Validate the given DTO.
	 *
	 * @param validator
	 *           - the validator to use for the validation
	 * @param validatee
	 *           - the object being validated
	 * @throws ValidationException
	 *            when validation errors were found
	 */
	void validate(Validator validator, Object validatee) throws ValidationException;

	/**
	 * Validate the given DTO.
	 *
	 * @param validator
	 *           - the validator to use for the validation
	 * @param validatee
	 *           - the object being validated
	 * @param bindingObject
	 *           - the object to use for binding the field errors
	 * @throws ValidationException
	 *            when validation errors were found
	 */
	void validate(Validator validator, Object validatee, Object bindingObject) throws ValidationException;

}
