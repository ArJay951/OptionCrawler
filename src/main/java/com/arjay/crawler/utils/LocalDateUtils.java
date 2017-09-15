package com.arjay.crawler.utils;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDateUtils {

	private static Logger log = LoggerFactory.getLogger(LocalDateUtils.class);

	public static boolean vaildDate(String date) {
		try {
			LocalDate.parse(date);
			return true;
		} catch (Exception e) {
			log.info("date error :{}", date);
			return false;
		}
	}
}
