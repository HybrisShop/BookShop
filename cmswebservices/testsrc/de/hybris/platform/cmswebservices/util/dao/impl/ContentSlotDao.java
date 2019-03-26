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
package de.hybris.platform.cmswebservices.util.dao.impl;

import de.hybris.platform.cms2.model.contents.contentslot.ContentSlotModel;


public class ContentSlotDao extends AbstractCmsWebServicesDao<ContentSlotModel>
{

	@Override
	protected String getQuery()
	{
		return "SELECT {pk} FROM {ContentSlot} WHERE {uid}=?uid AND {catalogVersion}=?catalogVersion";
	}

}
