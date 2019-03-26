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
package de.hybris.platform.sap.sapordermgmtbol.transaction.salesdocument.backend.impl.erp.strategy;

import de.hybris.platform.sap.sapordermgmtbol.transaction.salesdocument.backend.interf.erp.strategy.GetAllStrategy;

/**
 * Implementation for ERP 6.04 of StrategyFactoryERP. <br>
 * 
 * @see StrategyFactoryERP
 * @version 1.0
 */
public class StrategyFactoryERP604 extends StrategyFactoryERP {

    @Override
    public GetAllStrategy createGetAllStrategy() {
        return new GetAllStrategyERP604();
    }

}
