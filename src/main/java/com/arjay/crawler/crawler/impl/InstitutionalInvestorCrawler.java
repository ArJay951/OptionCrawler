package com.arjay.crawler.crawler.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.arjay.crawler.crawler.AbstractCrawler;
import com.arjay.crawler.exception.CrawlerException;
import com.arjay.crawler.pojo.enums.OptionType;
import com.arjay.crawler.pojo.mysql.InstitutionalInvestor;

@Service
public class InstitutionalInvestorCrawler extends AbstractCrawler<InstitutionalInvestor> {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(InstitutionalInvestorCrawler.class);

	@Override
	public List<InstitutionalInvestor> parseDailyData() {
		if (res == null) {
			throw new CrawlerException("連線有誤，請先建立連線");
		}

		Document doc = Jsoup.parse(res.body());
		Elements trs = doc.select("tr.12bk");

		List<InstitutionalInvestor> daliy = new ArrayList<>();
		OptionType optionType = null;
		for (int i = 3; i < trs.size(); i++) {
			Elements tds = trs.get(i).select("td");

			if (tds.size() == 16 || tds.size() == 14) {
				optionType = OptionType.parseOf(tds.get(tds.size() == 16 ? 2 : 0).text().replaceAll("\\s", ""));
			}

			InstitutionalInvestor investor = parser.parserData(tds);
			investor.setLocalDate(targetDate);
			investor.setOptionType(optionType);

			daliy.add(investor);
		}
		return daliy;
	}

	@Override
	protected Map<String, String> getParams() {
		Map<String, String> data = new HashMap<>();
		data.put("DATA_DATE_Y", String.valueOf(targetDate.getYear()));
		data.put("DATA_DATE_M", String.valueOf(targetDate.getMonthValue()));
		data.put("DATA_DATE_D", String.valueOf(targetDate.getDayOfMonth()));
		data.put("syear", String.valueOf(targetDate.getYear()));
		data.put("smonth", String.valueOf(targetDate.getMonthValue()));
		data.put("sday", String.valueOf(targetDate.getDayOfMonth()));
		data.put("datestart", targetDate.toString().replaceAll("/", "-"));
		data.put("COMMODITY_ID", "TXO");
		return data;
	}

	@Override
	protected Class<InstitutionalInvestor> getDataClass() {
		return InstitutionalInvestor.class;
	}

	@Override
	protected String getSourcePage() {
		return targetPage = "http://www.taifex.com.tw/chinese/3/7_12_5.asp";
	}

}
