package com.arjay.crawler.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/crawler")
public class CrawlerController {

	@RequestMapping(value = "/byDate")
	public ResponseEntity<?> byDate(@RequestParam LocalDate localDate) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
