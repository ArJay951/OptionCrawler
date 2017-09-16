package com.arjay.crawler.service;

import java.time.LocalDate;
import java.util.List;

public interface OptionCrawler<T> {

	public boolean connectWith(LocalDate date);

	public List<T> parseDailyData();

}
