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
package de.hybris.platform.sap.sapcarintegration.services;

import java.util.List;

import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.sap.sapcarintegration.data.CarMultichannelOrderHistoryData;

public interface MultichannelOrderHistoryService extends CarOrderHistoryService {

	/**
	 * reads the all transactions (hybris + pos + SD) for a given customer
	 * @param customerNumber
	 * @param paginationData
	 * @return {@link List<CarMultichannelOrderHistoryData>}
	 */
	abstract List<CarMultichannelOrderHistoryData> readMultiChannelTransactionsForCustomer(String customerNumber, PaginationData paginationData);

	/**
	 * read detail for sales document 
	 * @param customerNumber
	 * @param transactionNumber
	 * @return {@link CarMultichannelOrderHistoryData}
	 */
	abstract CarMultichannelOrderHistoryData readSalesDocumentDetails(String customerNumber, String transactionNumber);
}
