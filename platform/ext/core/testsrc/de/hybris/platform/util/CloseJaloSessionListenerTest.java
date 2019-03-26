/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.util;

import de.hybris.bootstrap.annotations.UnitTest;

import javax.servlet.http.HttpSessionEvent;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;



@UnitTest
public class CloseJaloSessionListenerTest
{

	@Test
	public void shouldNotThrowIllegalStateExceptionWhenNoTenantIsActive() //see PLA-12995
	{
		final HttpSessionEvent event = new HttpSessionEvent(new MockHttpSession());
		new CloseJaloSessionListener().sessionDestroyed(event);
	}
}
