package com.arjay.crawler.parser.impl;

import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.parser.OptionParser;
import com.arjay.crawler.pojo.LargeAmountInvestor;

public class LargeAmountInvestorParser implements OptionParser<LargeAmountInvestor> {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(LargeAmountInvestorParser.class);

	@Override
	public LargeAmountInvestor parserData(final Elements tds) {
		if (tds.size() == 0) {
			return null;
		}

		final LargeAmountInvestor option = new LargeAmountInvestor();

		int i = tds.size() == 11 ? 1 : 0;

		option.setPeriod(tds.get(i++).text());

		String[] top5HolderLot = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop5HolderLot(Integer.parseInt(top5HolderLot[0]));
		option.setSpecialTop5HolderLot(Integer.parseInt(top5HolderLot[1]));

		String[] top5HolderPercent = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop5HolderPercent(Float.parseFloat(top5HolderPercent[0]));
		option.setSpecialTop5HolderPercent(Float.parseFloat(top5HolderPercent[1]));

		String[] top10HolderLot = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop10HolderLot(Integer.parseInt(top10HolderLot[0]));
		option.setSpecialTop10HolderLot(Integer.parseInt(top10HolderLot[1]));

		String[] top10HolderPercent = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop10HolderPercent(Float.parseFloat(top10HolderPercent[0]));
		option.setSpecialTop10HolderPercent(Float.parseFloat(top10HolderPercent[1]));

		String[] top5SellerLot = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop5SellerLot(Integer.parseInt(top5SellerLot[0]));
		option.setSpecialTop5SellerLot(Integer.parseInt(top5SellerLot[1]));

		String[] top5SellerPercent = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop5SellerPercent(Float.parseFloat(top5SellerPercent[0]));
		option.setSpecialTop5SellerPercent(Float.parseFloat(top5SellerPercent[1]));

		String[] top10SellerLot = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop10SellerLot(Integer.parseInt(top10SellerLot[0]));
		option.setSpecialTop10SellerLot(Integer.parseInt(top10SellerLot[1]));

		String[] top10SellerPercent = this.replaceAndSplitRawData(tds.get(i++).text());
		option.setTop10SellerPercent(Float.parseFloat(top10SellerPercent[0]));
		option.setSpecialTop10SellerPercent(Float.parseFloat(top10SellerPercent[1]));

		option.setBalanceKeepLot(tds.get(i).text().replaceAll(",", ""));

		return option;
	}

	private String[] replaceAndSplitRawData(String raw) {
		return raw.replaceAll("[\\s,\\)%]", "").split("\\(");
	}
}
