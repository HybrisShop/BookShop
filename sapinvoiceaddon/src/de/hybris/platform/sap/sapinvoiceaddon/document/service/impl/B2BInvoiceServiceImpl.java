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
package de.hybris.platform.sap.sapinvoiceaddon.document.service.impl;

import de.hybris.platform.sap.sapinvoiceaddon.document.dao.B2BInvoiceDao;
import de.hybris.platform.sap.sapinvoiceaddon.document.service.B2BInvoiceService;
import de.hybris.platform.sap.sapinvoiceaddon.model.SapB2BDocumentModel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


/**
 *
 */
public class B2BInvoiceServiceImpl implements B2BInvoiceService
{
	private static final Logger LOG = Logger.getLogger(B2BInvoiceServiceImpl.class.getName());


	private B2BInvoiceDao b2bInvoiceDao;



	@Override
	public SapB2BDocumentModel getInvoiceForDocumentNumber(final String invoiceDocumentNumber)
	{
		try
		{
			return getB2bInvoiceDao().findInvoiceByDocumentNumber(invoiceDocumentNumber);
		}
		catch (final Exception e)
		{
			LOG.info("Flexible search error for invoice number: " + invoiceDocumentNumber);
			return null;
		}
	}

	/**
	 * @return the b2bInvoiceDao
	 */
	public B2BInvoiceDao getB2bInvoiceDao()
	{
		return b2bInvoiceDao;
	}

	/**
	 * @param b2bInvoiceDao
	 *           the b2bInvoiceDao to set
	 */
	@Required
	public void setB2bInvoiceDao(final B2BInvoiceDao b2bInvoiceDao)
	{
		this.b2bInvoiceDao = b2bInvoiceDao;
	}

}
