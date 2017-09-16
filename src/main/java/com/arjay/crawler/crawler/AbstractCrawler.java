package com.arjay.crawler.crawler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.exception.CrawlerException;
import com.arjay.crawler.parser.OptionParser;
import com.arjay.crawler.parser.ParserFactory;
import com.arjay.crawler.utils.ConnectUtils;

public abstract class AbstractCrawler<T> {

	private static Logger log = LoggerFactory.getLogger(AbstractCrawler.class);

	protected String targetPage;

	protected LocalDate targetDate;

	protected Response res;

	protected OptionParser<T> parser = ParserFactory.getParser(this.getDataClass());

	protected abstract Class<T> getDataClass();

	public AbstractCrawler<T> setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
		return this;
	}

	public AbstractCrawler<T> connect() {
		log.info("目標頁面：{}", this.getSourcePage());
		log.info("目標日期：{}", targetDate);
		log.info("連線設定：{}", getParams());
		try {
			this.res = ConnectUtils.getDefaultConnection(this.getSourcePage()).data(this.getParams())
					.method(Method.POST).execute();
			return this;
		} catch (IOException e) {
			log.info("連線有誤，可能是沒資料或者連線有問題。");
			throw new CrawlerException("連線有誤，可能是沒資料或者連線有問題。");
		}
	}

	public abstract List<T> parseDailyData();

	protected abstract Map<String, String> getParams();

	protected abstract String getSourcePage();
}
