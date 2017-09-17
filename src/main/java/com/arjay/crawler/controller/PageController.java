package com.arjay.crawler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PageController {

	@RequestMapping("/index")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public String index() {
		return "Hello";
	}

}
