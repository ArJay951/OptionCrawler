package com.arjay.crawler.service;

import org.jsoup.select.Elements;

import com.arjay.crawler.pojo.InstitutionalInvestor;

public interface OptionParser {

	public InstitutionalInvestor toInstitutionalInvestor(Elements tds);

}
