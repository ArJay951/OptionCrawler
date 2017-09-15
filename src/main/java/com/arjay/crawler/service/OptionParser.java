package com.arjay.crawler.service;

import org.jsoup.select.Elements;

import com.arjay.crawler.pojo.Option;

public interface OptionParser {

	public Option fromElements(Elements tds);

}
