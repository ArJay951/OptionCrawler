package com.arjay.crawler.task;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arjay.crawler.crawler.impl.InstitutionalInvestorCrawler;
import com.arjay.crawler.crawler.impl.LargeAmountInvestorCrawler;
import com.arjay.crawler.pojo.mysql.InstitutionalInvestor;
import com.arjay.crawler.pojo.mysql.LargeAmountInvestor;
import com.arjay.crawler.repository.InstitutionalInvestorRepository;
import com.arjay.crawler.repository.LargeAmountInvestorRepository;

public class InstitutionalInvestorTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(InstitutionalInvestorTask.class);

	private InstitutionalInvestorCrawler institutionalInvestorCrawler;

	private InstitutionalInvestorRepository institutionalInvestorRepository;

	private LocalDate targetDate;
	
	// @formatter:off
	public InstitutionalInvestorTask(LocalDate targetDate,
			InstitutionalInvestorCrawler institutionalInvestorCrawler,
			InstitutionalInvestorRepository institutionalInvestorRepository) {
		this.targetDate = targetDate;
		this.institutionalInvestorCrawler= institutionalInvestorCrawler;
		this.institutionalInvestorRepository = institutionalInvestorRepository;
	}
	// @formatter:on

	@Override
	public void run() {
		log.info("*** start Institutional Investor crawling task ***");
		log.info("institutionalInvestorCrawler:{}", institutionalInvestorCrawler);
		log.info("institutionalInvestorRepository:{}", institutionalInvestorRepository);

		List<InstitutionalInvestor> institutionalInvestors = institutionalInvestorCrawler.setTargetDate(targetDate)
				.connect().parseDailyData().stream().collect(Collectors.toList());

		institutionalInvestorRepository.save(institutionalInvestors);

		log.info("*** end Institutional Investor crawling task ***");
	}

}
