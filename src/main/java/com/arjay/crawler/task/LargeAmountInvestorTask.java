package com.arjay.crawler.task;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.crawler.impl.LargeAmountInvestorCrawler;
import com.arjay.crawler.pojo.mysql.LargeAmountInvestor;
import com.arjay.crawler.repository.LargeAmountInvestorRepository;

public class LargeAmountInvestorTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(LargeAmountInvestorTask.class);

	private LargeAmountInvestorCrawler largeAmountInvestorCrawler;

	private LargeAmountInvestorRepository largeAmountInvestorRepository;

	private LocalDate targetDate;

	// @formatter:off
	public LargeAmountInvestorTask(LocalDate targetDate, 
			LargeAmountInvestorCrawler largeAmountInvestorCrawler,
			LargeAmountInvestorRepository largeAmountInvestorRepository) {
		this.targetDate = targetDate;
		this.largeAmountInvestorCrawler = largeAmountInvestorCrawler;
		this.largeAmountInvestorRepository = largeAmountInvestorRepository;
	}
	// @formatter:on

	@Override
	public void run() {
		log.info("*** start Large Amount Investor crawling task ***");
		List<LargeAmountInvestor> largeAmountInvestors = largeAmountInvestorCrawler.setTargetDate(targetDate).connect()
				.parseDailyData().stream().collect(Collectors.toList());

		largeAmountInvestorRepository.save(largeAmountInvestors);
		log.info("*** end Large Amount Investor crawling task ***");
	}

}
