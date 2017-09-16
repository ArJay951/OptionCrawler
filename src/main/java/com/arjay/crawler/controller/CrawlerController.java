package com.arjay.crawler.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arjay.crawler.task.CrawlerTask;

@RestController
@RequestMapping(value = "/crawler")
public class CrawlerController {

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@RequestMapping(value = "/byDate")
	public ResponseEntity<?> byDate(@RequestParam LocalDate date) {
		taskExecutor.execute(new CrawlerTask(date));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
