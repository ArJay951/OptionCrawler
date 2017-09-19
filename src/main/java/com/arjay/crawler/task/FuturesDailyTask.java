package com.arjay.crawler.task;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.crawler.impl.FuturesDailyCrawler;
import com.arjay.crawler.pojo.mysql.FuturesDaily;
import com.arjay.crawler.repository.FuturesDailyRepository;

public class FuturesDailyTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(FuturesDailyTask.class);

	private FuturesDailyCrawler FuturesDailyCrawler;

	private FuturesDailyRepository FuturesDailyRepository;

	private LocalDate targetDate;

	// @formatter:off
	public FuturesDailyTask(LocalDate targetDate,
			FuturesDailyCrawler FuturesDailyCrawler,
			FuturesDailyRepository FuturesDailyRepository) {
		this.targetDate = targetDate;
		this.FuturesDailyCrawler= FuturesDailyCrawler;
		this.FuturesDailyRepository = FuturesDailyRepository;
	}
	// @formatter:on

	@Override
	public void run() {
		log.info("*** start Futures Daily crawling task ***");
		log.info("FuturesDailyCrawler:{}", FuturesDailyCrawler);
		log.info("FuturesDailyRepository:{}", FuturesDailyRepository);

		List<FuturesDaily> futuresDailys = FuturesDailyCrawler.setTargetDate(targetDate).connect().parseDailyData()
				.stream().collect(Collectors.toList());

		FuturesDailyRepository.save(futuresDailys);

		log.info("*** end Institutional Investor crawling task ***");
	}

}
