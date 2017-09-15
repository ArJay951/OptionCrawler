package com.arjay.crawler.service.impl;

import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.pojo.Option;
import com.arjay.crawler.pojo.enums.Investor;
import com.arjay.crawler.service.OptionParser;

public class OptionParserImpl implements OptionParser {

	private Logger log = LoggerFactory.getLogger(OptionParserImpl.class);

	@Override
	public Option fromElements(final Elements tds) {
		if (tds.size() == 0) {
			return null;
		}

		final Option option = new Option();

		int i = tds.size() == 16 ? 3 : tds.size() == 14 ? 1 : 0;

		option.setInvestor(Investor.parseOf(tds.get(i++).text()));
		option.setHolderDealtLot(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setHolderDealtAmount(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setSellerDealtLot(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setSellerDealtAmount(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setBalanceDealtLot(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setBalanceDealtAmount(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setHolderKeepLot(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setHolderKeepAmount(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setSellerKeepLot(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setSellerKeepAmount(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setBalanceKeepLot(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));
		option.setBalanceKeepAmount(Long.parseLong(tds.get(i++).text().replaceAll(",", "")));

		return option;
	}

}
