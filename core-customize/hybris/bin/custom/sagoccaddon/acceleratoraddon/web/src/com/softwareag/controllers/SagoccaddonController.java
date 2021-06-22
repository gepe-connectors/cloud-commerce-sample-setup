/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller("addonTestController")
@RequestMapping(value = "/{baseSiteId}")
public class SagoccaddonController 
{
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	@RequestMappingOverride
	@ResponseBody
	public String getTestResource() {
		return "Hello! This is a test resource output";
	}

}
