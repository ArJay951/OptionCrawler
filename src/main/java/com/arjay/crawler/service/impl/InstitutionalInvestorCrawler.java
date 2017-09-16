package com.arjay.crawler.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.exception.CrawlerException;
import com.arjay.crawler.pojo.InstitutionalInvestor;
import com.arjay.crawler.pojo.enums.OptionType;
import com.arjay.crawler.service.OptionCrawler;
import com.arjay.crawler.utils.ConnectUtils;
import com.arjay.crawler.utils.ParamsUtils;

public class InstitutionalInvestorCrawler implements OptionCrawler<InstitutionalInvestor> {

	private static Logger log = LoggerFactory.getLogger(InstitutionalInvestorCrawler.class);

	private static final String sourceUrl = "http://www.taifex.com.tw/chinese/3/7_12_5.asp";

	private InstitutionalInvestorParser institutionalInvestorParser;

	public InstitutionalInvestorCrawler(InstitutionalInvestorParser institutionalInvestorParser) {
		this.institutionalInvestorParser = institutionalInvestorParser;
	}

	private Response res;

	private LocalDate currentParseDate;

	@Override
	public boolean connectWith(LocalDate date) {
		// @formatter:off
		try {
			this.res = ConnectUtils.getDefaultConnection(sourceUrl)
				  .data(ParamsUtils.getRequestParams(date))
				  .method(Method.POST).execute();
		} catch (IOException e) {
			log.info("{}連線有誤。可能是沒資料或者連線有問題。再手動確認 ", date);
		}
		// @formatter:on
		return false;
	}

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

			InstitutionalInvestor investor = institutionalInvestorParser.toInstitutionalInvestor(tds);
			investor.setLocalDate(currentParseDate);
			investor.setOptionType(optionType);

			daliy.add(investor);
		}
		return daliy;
	}

}
