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
package de.hybris.platform.sap.core.bol.businessobject.test.be;

import de.hybris.platform.sap.core.bol.backend.BackendBusinessObjectBase;
import de.hybris.platform.sap.core.bol.backend.BackendType;


/**
 * Test BackendBusinedssObjectBase implementation - for backend type determination where the determination is not
 * unique.
 */
@BackendType("CRM")
public class TestBackendBusinessObjectBaseBEDeterminationCRMImpl extends BackendBusinessObjectBase implements
		TestBackendInterfaceBEDetermination
{
	// only for testing
}
