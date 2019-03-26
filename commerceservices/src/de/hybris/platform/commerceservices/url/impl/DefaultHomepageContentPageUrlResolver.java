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
package de.hybris.platform.commerceservices.url.impl;

import de.hybris.platform.cms2.model.pages.ContentPageModel;
import org.springframework.beans.factory.annotation.Required;


public class DefaultHomepageContentPageUrlResolver extends AbstractUrlResolver<ContentPageModel>
{
	private final String CACHE_KEY = DefaultHomepageContentPageUrlResolver.class.getName();

	private String pattern;

	protected String getPattern()
	{
		return pattern;
	}

	@Required
	public void setPattern(final String pattern)
	{
		this.pattern = pattern;
	}

	@Override
	protected String getKey(final ContentPageModel source)
	{
		return CACHE_KEY + "." + source.getPk().toString();
	}

	@Override
	protected String resolveInternal(final ContentPageModel source)
	{
		// default url is /
		// Replace pattern values
		String url = getPattern();
		return url;
	}
}
