package com.arjay.crawler.crawler.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.arjay.crawler.crawler.AbstractCrawler;
import com.arjay.crawler.exception.CrawlerException;
import com.arjay.crawler.parser.impl.FuturesDailyParser;
import com.arjay.crawler.pojo.mysql.FuturesDaily;
import com.arjay.crawler.utils.LocalDateUtils;

@Component
public class FuturesDailyCrawler extends AbstractCrawler<FuturesDaily> {

	private static Logger log = LoggerFactory.getLogger(FuturesDailyCrawler.class);

	@Override
	public List<FuturesDaily> parseDailyData() {
		if (res == null) {
			throw new CrawlerException("連線有誤，請先建立連線");
		}

		Document doc = Jsoup.parse(res.body());
		Elements trs = doc.select("tr[bgcolor~=(ivory|#CFDFEF)]");

		List<FuturesDaily> daliy = new ArrayList<>();
		for (int i = 0; i < trs.size(); i++) {
			Elements tds = trs.get(i).select("td");

			FuturesDaily futuresDaily = parser.parserData(tds);
			if (futuresDaily == null) {
				continue;
			}
			futuresDaily.setDate(LocalDateUtils.asDate(targetDate));

			daliy.add(futuresDaily);
		}
		return daliy;
	}

	@Override
	protected Map<String, String> getParams() {
		Map<String, String> data = new HashMap<>();
		data.put("qtype", "2");
		data.put("DATA_DATE_Y", String.valueOf(targetDate.getYear()));
		data.put("DATA_DATE_M", String.valueOf(targetDate.getMonthValue()));
		data.put("DATA_DATE_D", String.valueOf(targetDate.getDayOfMonth()));
		data.put("syear", String.valueOf(targetDate.getYear()));
		data.put("smonth", String.valueOf(targetDate.getMonthValue()));
		data.put("sday", String.valueOf(targetDate.getDayOfMonth()));
		data.put("datestart", targetDate.toString().replaceAll("/", "-"));
		data.put("COMMODITY_ID", "TX");

		return data;
	}

	@Override
	protected Class<FuturesDaily> getDataClass() {
		return FuturesDaily.class;
	}

	@Override
	protected String getSourcePage() {
		return targetPage = "http://www.taifex.com.tw/chinese/3/3_1_1.asp";
	}

	public static void main(String[] args) {
		new FuturesDailyCrawler().setTargetDate(LocalDate.now()).connect().setParser(new FuturesDailyParser())
				.parseDailyData();
	}

}
