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
import com.arjay.crawler.pojo.mysql.LargeAmountInvestor;

@Service
public class LargeAmountInvestorCrawler extends AbstractCrawler<LargeAmountInvestor> {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(LargeAmountInvestorCrawler.class);

	@Override
	public List<LargeAmountInvestor> parseDailyData() {
		if (res == null) {
			throw new CrawlerException("連線有誤，請先建立連線");
		}

		Document doc = Jsoup.parse(res.body());
		Elements trs = doc.select("tbody > tr");

		List<LargeAmountInvestor> daliy = new ArrayList<>();
		String contractName = null;
		for (int i = 10; i < trs.size(); i++) {
			Elements tds = trs.get(i).select("td");

			if (tds.size() != 10 && tds.size() != 11) {
				continue;
			}

			if (tds.size() == 11) {
				contractName = tds.get(0).text().replaceAll("\\s", "");
			}

			LargeAmountInvestor investor = parser.parserData(tds);
			investor.setLocalDate(targetDate);
			investor.setContractName(contractName);

			daliy.add(investor);
		}
		return daliy;
	}

	@Override
	protected Map<String, String> getParams() {
		Map<String, String> data = new HashMap<>();
		data.put("pFlag", "");
		data.put("yytemp", String.valueOf(targetDate.getYear()));
		data.put("mmtemp", String.valueOf(targetDate.getMonthValue()));
		data.put("ddtemp", String.valueOf(targetDate.getDayOfMonth()));
		data.put("goday", "");
		data.put("chooseitemtemp", "ALL");
		data.put("choose_yy", String.valueOf(targetDate.getYear()));
		data.put("choose_mm", String.valueOf(targetDate.getMonthValue()));
		data.put("choose_dd", String.valueOf(targetDate.getDayOfMonth()));
		data.put("datestart", targetDate.toString().replaceAll("/", "-"));
		data.put("choose_item", "TXO");

		return data;
	}

	@Override
	protected Class<LargeAmountInvestor> getDataClass() {
		return LargeAmountInvestor.class;
	}

	@Override
	protected String getSourcePage() {
		return targetPage = "http://www.taifex.com.tw/chinese/3/7_9.asp";
	}

}
