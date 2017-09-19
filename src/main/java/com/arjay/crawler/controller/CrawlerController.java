package com.arjay.crawler.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arjay.crawler.crawler.impl.FuturesDailyCrawler;
import com.arjay.crawler.crawler.impl.InstitutionalInvestorCrawler;
import com.arjay.crawler.crawler.impl.LargeAmountInvestorCrawler;
import com.arjay.crawler.repository.FuturesDailyRepository;
import com.arjay.crawler.repository.InstitutionalInvestorRepository;
import com.arjay.crawler.repository.LargeAmountInvestorRepository;
import com.arjay.crawler.task.FuturesDailyTask;
import com.arjay.crawler.task.InstitutionalInvestorTask;
import com.arjay.crawler.task.LargeAmountInvestorTask;

@RestController
@RequestMapping(value = "/crawler")
public class CrawlerController {

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private InstitutionalInvestorCrawler institutionalInvestorCrawler;

	@Autowired
	private InstitutionalInvestorRepository institutionalInvestorRepository;

	@Autowired
	private LargeAmountInvestorCrawler largeAmountInvestorCrawler;

	@Autowired
	private LargeAmountInvestorRepository largeAmountInvestorRepository;

	@Autowired
	private FuturesDailyCrawler futuresDailyCrawler;

	@Autowired
	private FuturesDailyRepository futuresDailyRepository;

	@RequestMapping(value = "/byDate")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public String byDate(@RequestParam LocalDate date) {

		// 可以考慮用Callback的方式
		// @formatter:off
		taskExecutor.execute(new InstitutionalInvestorTask(date, institutionalInvestorCrawler, institutionalInvestorRepository));
		taskExecutor.execute(new LargeAmountInvestorTask(date, largeAmountInvestorCrawler, largeAmountInvestorRepository));
		taskExecutor.execute(new FuturesDailyTask(date, futuresDailyCrawler, futuresDailyRepository));
		// @formatter:on
		return "已將任務加入排程，目標日期為:" + date;
	}

}
