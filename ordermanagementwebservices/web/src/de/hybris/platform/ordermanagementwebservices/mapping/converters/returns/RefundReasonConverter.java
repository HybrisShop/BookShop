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
package de.hybris.platform.ordermanagementwebservices.mapping.converters.returns;

import de.hybris.platform.basecommerce.enums.RefundReason;
import de.hybris.platform.webservicescommons.mapping.WsDTOMapping;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;


/**
 * Bidirectional converter between {@link RefundReason} and String
 */
@WsDTOMapping
public class RefundReasonConverter extends BidirectionalConverter<RefundReason, String>
{
	@Override
	public RefundReason convertFrom(final String source, final Type<RefundReason> destinationType)
	{
		return RefundReason.valueOf(source);
	}

	@Override
	public String convertTo(final RefundReason source, final Type<String> destinationType)
	{
		return source.toString();
	}
}
