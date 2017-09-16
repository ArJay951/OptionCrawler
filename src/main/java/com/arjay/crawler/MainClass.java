package com.arjay.crawler;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.config.ParamsConfig;
import com.arjay.crawler.pojo.InstitutionalInvestor;
import com.arjay.crawler.pojo.enums.Investor;
import com.arjay.crawler.service.impl.InstitutionalInvestorCrawler;
import com.arjay.crawler.service.impl.InstitutionalInvestorParser;
import com.arjay.crawler.utils.FileUtils;

public class MainClass {

	private static Logger log = LoggerFactory.getLogger(MainClass.class);

	public static void main(String[] args) throws InterruptedException {

		ParamsConfig paramsConfig = new ParamsConfig(args);
		
		Random random = new Random(System.currentTimeMillis());
		
		InstitutionalInvestorCrawler institutionalInvestorCrawler = new InstitutionalInvestorCrawler(new InstitutionalInvestorParser());
		
		
		StringBuilder sb = new StringBuilder();
		sb.append('\ufeff');
		sb.append(Arrays.asList(InstitutionalInvestor.fields).stream().collect(Collectors.joining(",")));

		LocalDate targetDate = paramsConfig.getStartDate();
		LocalDate endDate = paramsConfig.getEndDate();

		log.info("系統將從{}爬資料到{}", targetDate, endDate);
		
		for (; targetDate.isBefore(endDate); targetDate = targetDate.plusDays(1)) {
			institutionalInvestorCrawler.connectWith(targetDate);
			
			institutionalInvestorCrawler.parseDailyData().forEach(investor->{
				if (!paramsConfig.isFilterFI() || investor.getInvestor() == Investor.FI) {
					sb.append(investor.toCsv());
					sb.append(System.getProperty("line.separator"));
				}
			});
			
			Thread.sleep(Math.abs(random.nextLong() % 1000 + 500));
		}

		String fileName = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss").format(LocalDateTime.now());
		log.info("寫入檔案：{}", fileName);
		Path pathTo = Paths.get("./" + fileName + ".csv");

		FileUtils.writeFile(pathTo, sb.toString().getBytes());
	}

}
