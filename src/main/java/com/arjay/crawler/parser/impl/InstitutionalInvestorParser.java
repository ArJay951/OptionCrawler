package com.arjay.crawler.parser.impl;

import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.arjay.crawler.parser.OptionParser;
import com.arjay.crawler.pojo.enums.Investor;
import com.arjay.crawler.pojo.mysql.InstitutionalInvestor;

@Component
public class InstitutionalInvestorParser implements OptionParser<InstitutionalInvestor> {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(InstitutionalInvestorParser.class);

	@Override
	public InstitutionalInvestor parserData(final Elements tds) {
		if (tds.size() == 0) {
			return null;
		}

		final InstitutionalInvestor option = new InstitutionalInvestor();

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
