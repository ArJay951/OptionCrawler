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
		if (tds.size() == 0) {
			return null;
		}

		final FuturesDaily futuresDaily = new FuturesDaily();

		int i = tds.size() == 16 ? 3 : tds.size() == 14 ? 1 : 0;

//		option.setInvestor(Investor.parseOf(tds.get(i++).text()));
//		option.setHolderDealtLot(this.parseToLong(tds.get(i++).text()));
//		option.setHolderDealtAmount(this.parseToLong(tds.get(i++).text()));
//		option.setSellerDealtLot(this.parseToLong(tds.get(i++).text()));
//		option.setSellerDealtAmount(this.parseToLong(tds.get(i++).text()));
//		option.setBalanceDealtLot(this.parseToLong(tds.get(i++).text()));
//		option.setBalanceDealtAmount(this.parseToLong(tds.get(i++).text()));
//		option.setHolderKeepLot(this.parseToLong(tds.get(i++).text()));
//		option.setHolderKeepAmount(this.parseToLong(tds.get(i++).text()));
//		option.setSellerKeepLot(this.parseToLong(tds.get(i++).text()));
//		option.setSellerKeepAmount(this.parseToLong(tds.get(i++).text()));
//		option.setBalanceKeepLot(this.parseToLong(tds.get(i++).text()));
//		option.setBalanceKeepAmount(this.parseToLong(tds.get(i++).text()));

		return futuresDaily;
	}

//	private Long parseToLong(String raw) {
//		raw = raw.replaceAll("[,-]", "");
//		return StringUtils.isEmpty(raw) ? 0 : Long.parseLong(raw);
//	}

}
