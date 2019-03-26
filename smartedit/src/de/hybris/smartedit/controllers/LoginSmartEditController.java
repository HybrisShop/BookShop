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
package de.hybris.smartedit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static de.hybris.smartedit.controllers.Page.LOGIN_PAGE;

@Controller
public class LoginSmartEditController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage()
    {
        return LOGIN_PAGE.getViewName();
    }

}