package com.arjay.crawler.task;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arjay.crawler.crawler.impl.InstitutionalInvestorCrawler;
import com.arjay.crawler.crawler.impl.LargeAmountInvestorCrawler;
import com.arjay.crawler.pojo.mysql.InstitutionalInvestor;
import com.arjay.crawler.pojo.mysql.LargeAmountInvestor;
import com.arjay.crawler.repository.InstitutionalInvestorRepository;
import com.arjay.crawler.repository.LargeAmountInvestorRepository;

public class CrawlerTask implements Runnable {

	@Autowired
	private InstitutionalInvestorCrawler institutionalInvestorCrawler;

	@Autowired
	private LargeAmountInvestorCrawler largeAmountInvestorCrawler;

	@Autowired
	private InstitutionalInvestorRepository institutionalInvestorRepository;

	@Autowired
	private LargeAmountInvestorRepository largeAmountInvestorRepository;

	private LocalDate targetDate;

	public CrawlerTask(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public void run() {
		List<InstitutionalInvestor> institutionalInvestors = institutionalInvestorCrawler.setTargetDate(targetDate)
				.connect().parseDailyData().stream().collect(Collectors.toList());

		institutionalInvestorRepository.save(institutionalInvestors);

		List<LargeAmountInvestor> largeAmountInvestors = largeAmountInvestorCrawler.setTargetDate(targetDate).connect()
				.parseDailyData().stream().collect(Collectors.toList());

		largeAmountInvestorRepository.save(largeAmountInvestors);
	}

}
