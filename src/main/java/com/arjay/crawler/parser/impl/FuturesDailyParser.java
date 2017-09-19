package com.arjay.crawler.parser.impl;

import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.arjay.crawler.parser.OptionParser;
import com.arjay.crawler.pojo.mysql.FuturesDaily;

@Component
public class FuturesDailyParser implements OptionParser<FuturesDaily> {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(FuturesDailyParser.class);

	@Override
	public FuturesDaily parserData(final Elements tds) {
		if (tds.size() != 17 || " ".equals(tds.get(0).text())) {
			return null;
		}

		final FuturesDaily futuresDaily = new FuturesDaily();

		int i = 0;
		futuresDaily.setContract(tds.get(i++).text());
		futuresDaily.setPeriod(tds.get(i++).text());
		futuresDaily.setOpeningPrice(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setHighestPrice(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setLowestPrice(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setFinalPrice(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setChange(Integer.parseInt(tds.get(i++).text().replaceAll("[^-0-9]", "")));
		futuresDaily.setChangePercent(Float.parseFloat(tds.get(i++).text().replaceAll("[^-0-9]", "")));
		futuresDaily.setAfterTradeTimeAmount(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setNormalTradeTimeAmount(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setTotalAmount(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setSettlementPrice(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setOpenInterest(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setFinalBuyPrice(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setFinalSellPrice(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setHighestInHistory(Integer.parseInt(tds.get(i++).text()));
		futuresDaily.setLowestInHistory(Integer.parseInt(tds.get(i++).text()));
		return futuresDaily;
	}

	public static void main(String[] args) {
		System.out.println("▼-55".replaceAll("[^-0-9]", ""));
	}

}
