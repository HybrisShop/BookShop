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
package de.hybris.platform.sap.sapcreditcheck.service;

import de.hybris.platform.commercefacades.order.data.AbstractOrderData; 


/**
 * 
 */
public interface SapCreditCheckService 
{
	/**
	 * 
	 * @return true if the credit limit has been exceeded
	 */
	abstract boolean checkCreditLimitExceeded(AbstractOrderData order);
	
	
	/**
	 * Check if the order is blocked in ERP due to exceeding credit limit
	 * @param orderCode
	 * @return true if order is credit blocked
	 */
	abstract boolean checkOrderCreditBlocked(String orderCode);
	
}
