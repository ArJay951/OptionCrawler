package com.arjay.crawler.parser;

import org.jsoup.select.Elements;

public interface OptionParser<T> {

	public T parserData(Elements tds);

}
