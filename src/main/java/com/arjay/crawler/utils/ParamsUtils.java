package com.arjay.crawler.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ParamsUtils {

	/**
	 * 期交所預設參數值
	 * 
	 * @param targetDate
	 * @return
	 */
	public static Map<String, String> getRequestParams(LocalDate targetDate) {
		Map<String, String> data = new HashMap<>();
		data.put("DATA_DATE_Y", String.valueOf(targetDate.getYear()));
		data.put("DATA_DATE_M", String.valueOf(targetDate.getMonthValue()));
		data.put("DATA_DATE_D", String.valueOf(targetDate.getDayOfMonth()));
		data.put("syear", String.valueOf(targetDate.getYear()));
		data.put("smonth", String.valueOf(targetDate.getMonthValue()));
		data.put("sday", String.valueOf(targetDate.getDayOfMonth()));
		data.put("datestart", targetDate.toString().replaceAll("/", "-"));
		data.put("COMMODITY_ID", "TXO");
		return data;
	}
}
