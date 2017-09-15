package com.arjay.crawler;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.config.OptionConfig;
import com.arjay.crawler.pojo.Option;
import com.arjay.crawler.pojo.OptionField;
import com.arjay.crawler.pojo.enums.Investor;
import com.arjay.crawler.pojo.enums.OptionType;
import com.arjay.crawler.service.OptionParser;
import com.arjay.crawler.service.impl.OptionParserImpl;
import com.arjay.crawler.utils.ConnectUtils;
import com.arjay.crawler.utils.FileUtils;
import com.arjay.crawler.utils.ParamsUtils;

public class MainClass {

	private static Logger log = LoggerFactory.getLogger(MainClass.class);

	public static void main(String[] args) throws InterruptedException {

		OptionConfig optionConfig = new OptionConfig(args);
		OptionParser parser = new OptionParserImpl();
		Random random = new Random(System.currentTimeMillis());

		StringBuilder sb = new StringBuilder();
		sb.append('\ufeff');
		sb.append(Arrays.asList(OptionField.fields).stream().collect(Collectors.joining(",")));
		sb.append(System.getProperty("line.separator"));

		LocalDate targetDate = optionConfig.getStartDate();
		LocalDate endDate = optionConfig.getEndDate();

		log.info("系統將從{}爬資料到{}", targetDate, endDate);

		for (; targetDate.isBefore(endDate); targetDate = targetDate.plusDays(1)) {
			sb.append(System.getProperty("line.separator"));

			log.info("crawler date:{}", targetDate);
			
			// @formatter:off
			Response res;
			try {
				res = ConnectUtils.getDefaultConnection()
					  .data(ParamsUtils.getRequestParams(targetDate))
					  .method(Method.POST).execute();
			} catch (IOException e) {
				log.info("{}連線有誤。可能是沒資料或者連線有問題。再手動確認 ", targetDate);
				continue;
			}
			// @formatter:on

			Document doc = Jsoup.parse(res.body());
			Elements trs = doc.select("tr.12bk");

			OptionType optionType = null;
			for (int i = 3; i < trs.size(); i++) {
				Elements tds = trs.get(i).select("td");

				if (tds.size() == 16 || tds.size() == 14) {
					optionType = OptionType.parseOf(tds.get(tds.size() == 16 ? 2 : 0).text().replaceAll("\\s", ""));
				}

				Option option = parser.fromElements(tds);
				option.setLocalDate(targetDate);
				option.setOptionType(optionType);

				if (!optionConfig.isFilterFI() || option.getInvestor() == Investor.FI) {
					sb.append(option.toCsv());
					sb.append(System.getProperty("line.separator"));
				}
			}
			Thread.sleep(Math.abs(random.nextLong() % 2000 + 500));
		}

		String fileName = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss").format(LocalDateTime.now());
		Path pathTo = Paths.get("./" + fileName + ".csv");

		FileUtils.writeFile(pathTo, sb.toString().getBytes());
	}

}
