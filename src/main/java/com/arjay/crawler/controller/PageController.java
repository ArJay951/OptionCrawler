package com.arjay.crawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PageController {

	private static final Logger log = LoggerFactory.getLogger(PageController.class);


	@RequestMapping("/index")
	@ResponseStatus(value = HttpStatus.OK)
	public String index() {
		return "index";
	}
}
