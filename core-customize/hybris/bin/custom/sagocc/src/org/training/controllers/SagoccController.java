/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller("testController")
@RequestMapping(value = "/{baseSiteId}/test")
public class SagoccController 
{
	
	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	@ResponseBody
	public String getTestResource() {
		return "Hello! This is a test resource output";
	}

}
