package com.arjay.crawler;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arjay.crawler.config.ParamsConfig;
import com.arjay.crawler.crawler.impl.InstitutionalInvestorCrawler;
import com.arjay.crawler.crawler.impl.LargeAmountInvestorCrawler;
import com.arjay.crawler.pojo.mysql.InstitutionalInvestor;
import com.arjay.crawler.pojo.mysql.LargeAmountInvestor;
import com.arjay.crawler.utils.FileUtils;

public class ConsoleMainClass {

	private static Logger log = LoggerFactory.getLogger(ConsoleMainClass.class);

	public static void main(String[] args) throws InterruptedException {

		ParamsConfig paramsConfig = new ParamsConfig(args);

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		
		Random random = new Random(System.currentTimeMillis());

		InstitutionalInvestorCrawler institutionalInvestorCrawler = new InstitutionalInvestorCrawler();
		LargeAmountInvestorCrawler largeAmountInvestorCrawler = new LargeAmountInvestorCrawler();

		StringBuilder sb = new StringBuilder();
		sb.append('\ufeff');

		sb.append(Arrays.asList(InstitutionalInvestor.fields).stream().collect(Collectors.joining(",")));
		sb.append(System.getProperty(","));
		sb.append(Arrays.asList(LargeAmountInvestor.fields).stream().collect(Collectors.joining(",")));
		sb.append(System.getProperty("line.separator"));

		LocalDate targetDate = paramsConfig.getStartDate();
		LocalDate endDate = paramsConfig.getEndDate();

		log.info("系統將從{}爬資料到{}", targetDate, endDate);

		for (; targetDate.isBefore(endDate); targetDate = targetDate.plusDays(1)) {
			List<InstitutionalInvestor> institutionalInvestors = institutionalInvestorCrawler.setTargetDate(targetDate)
					.connect().parseDailyData().stream().collect(Collectors.toList());

			List<LargeAmountInvestor> largeAmountInvestors = largeAmountInvestorCrawler.setTargetDate(targetDate)
					.connect().parseDailyData().stream().collect(Collectors.toList());

			int length = institutionalInvestors.size();
			length = length > largeAmountInvestors.size() ? length : largeAmountInvestors.size();

			for (int i = 0; i < length; i++) {
				sb.append(i < institutionalInvestors.size() - 1 ? institutionalInvestors.get(i).toCsv() : ",,,,,,,,,,,,,,");
				sb.append(",");
				sb.append(i < largeAmountInvestors.size() - 1 ? largeAmountInvestors.get(i).toCsv() : "");
				sb.append(System.getProperty("line.separator"));
			}
			sb.append(System.getProperty("line.separator"));
			Thread.sleep(Math.abs(random.nextLong() % 1000 + 500));
		}

		String fileName = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss").format(LocalDateTime.now());
		log.info("寫入檔案：{}", fileName);
		Path pathTo = Paths.get("./" + fileName + ".csv");

		FileUtils.writeFile(pathTo, sb.toString().getBytes());
		
		//context.close();
	}

}
