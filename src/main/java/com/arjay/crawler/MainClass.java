package com.arjay.crawler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.pojo.Option;
import com.arjay.crawler.pojo.OptionField;
import com.arjay.crawler.pojo.enums.Investor;
import com.arjay.crawler.pojo.enums.OptionType;
import com.arjay.crawler.service.OptionParser;
import com.arjay.crawler.service.impl.OptionParserImpl;

public class MainClass {

	private static Logger log = LoggerFactory.getLogger(MainClass.class);

	public static void main(String[] args) throws InterruptedException, IOException {
		final String url = "http://www.taifex.com.tw/chinese/3/7_12_5.asp";

		LocalDate startLocalDate;
		LocalDate endLocalDate;

		boolean filter = true;

		if (args.length == 0) {
			startLocalDate = LocalDate.now().plusDays(-1);
			endLocalDate = LocalDate.now();
			log.info("系統將擷取前一天的資料。");
		} else if (args.length == 1 && MainClass.vaildDate(args[0])) {
			startLocalDate = LocalDate.parse(args[0]);
			endLocalDate = LocalDate.now();
		} else if (args.length == 2 && MainClass.vaildDate(args[0]) && MainClass.vaildDate(args[1])) {
			startLocalDate = LocalDate.parse(args[0]);
			endLocalDate = LocalDate.parse(args[1]);
		} else if (args.length == 3 && MainClass.vaildDate(args[0]) && MainClass.vaildDate(args[1])) {
			startLocalDate = LocalDate.parse(args[0]);
			endLocalDate = LocalDate.parse(args[1]);
			filter = "y".equalsIgnoreCase(args[2]) || "".equals(args[2]);
		} else {
			log.info("日期輸入有誤，建議輸入格式為：[yyyy-MM-dd]");
			return;
		}

		if (!startLocalDate.isBefore(endLocalDate)) {
			LocalDate temp = startLocalDate;
			startLocalDate = endLocalDate;
			endLocalDate = temp;
		}

		long days = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);

		OptionParser parser = new OptionParserImpl();

		Random random = new Random(System.currentTimeMillis());

		StringBuilder sb = new StringBuilder();
		sb.append('\ufeff');
		sb.append(Arrays.asList(OptionField.fields).stream().collect(Collectors.joining(",")));
		sb.append(System.getProperty("line.separator"));

		for (long day = days; day > 0; day--) {
			sb.append(System.getProperty("line.separator"));
			LocalDate parserDate = LocalDate.now().plusDays(day * -1);

			log.info("parseDate:{}", parserDate);

			Map<String, String> data = new HashMap<>();
			data.put("DATA_DATE_Y", String.valueOf(parserDate.getYear()));
			data.put("DATA_DATE_M", String.valueOf(parserDate.getMonthValue()));
			data.put("DATA_DATE_D", String.valueOf(parserDate.getDayOfMonth()));
			data.put("syear", String.valueOf(parserDate.getYear()));
			data.put("smonth", String.valueOf(parserDate.getMonthValue()));
			data.put("sday", String.valueOf(parserDate.getDayOfMonth()));
			data.put("datestart", parserDate.toString().replaceAll("/", "-"));
			data.put("COMMODITY_ID", "TXO");

			//@formatter:off
			Response res;
			try {
				res = Jsoup.connect(url.toString())
						.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
						.header("Accept-Encoding","gzip, deflate")
						.header("Accept-Language","zh-TW,zh;q=0.8,en-US;q=0.6,en;q=0.4")
						.header("Cache-Control","max-age=0")
						.header("Connection","keep-alive")
						.header("Content-Length","121")
						.header("Content-Type","application/x-www-form-urlencoded")
						.header("Cookie","ASPSESSIONIDCQDARDRA=IDPNGOOADDPJLIFCGCFKBGDD; AX-cookie-POOL_PORTAL=AGACBAKM; AX-cookie-POOL_PORTAL_web3=ADACBAKM")
						.header("Host","www.taifex.com.tw")
						.header("Upgrade-Insecure-Requests","1")
						.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
						.data(data)
						.method(Method.POST)
						.execute();
			} catch (IOException e) {
				continue;
			}
			//@formatter:on

			Document doc = Jsoup.parse(res.body());
			Elements trs = doc.select("tr.12bk");

			OptionType optionType = null;
			for (int i = 3; i < trs.size(); i++) {
				Elements tds = trs.get(i).select("td");

				if (tds.size() == 16 || tds.size() == 14) {
					optionType = OptionType.parseOf(tds.get(tds.size() == 16 ? 2 : 0).text().replaceAll("\\s", ""));
				}

				Option option = parser.fromElements(tds);
				option.setLocalDate(parserDate);
				option.setOptionType(optionType);
				if (filter) {
					if (option.getInvestor() == Investor.FI) {
						sb.append(option.toCsv());
						sb.append(System.getProperty("line.separator"));
					}
				} else {
					sb.append(option.toCsv());
					sb.append(System.getProperty("line.separator"));
				}
			}
			Thread.sleep(Math.abs(random.nextLong() % 2000 + 500));
		}

		String fileName = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss").format(LocalDateTime.now());
		Path pathTo = Paths.get("./" + fileName + ".csv");
		byte[] smallArray = sb.toString().getBytes();
		Files.write(pathTo, smallArray, new OpenOption[] { StandardOpenOption.CREATE, StandardOpenOption.WRITE });

	}

	public static boolean vaildDate(String date) {
		try {
			LocalDate.parse(date);
			return true;
		} catch (Exception e) {
			log.info("date error :{}", date);
			return false;
		}
	}
}
