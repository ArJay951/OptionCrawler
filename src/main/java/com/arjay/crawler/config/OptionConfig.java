package com.arjay.crawler.config;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjay.crawler.exception.ParamsException;
import com.arjay.crawler.utils.LocalDateUtils;

public class OptionConfig {

	private static Logger log = LoggerFactory.getLogger(OptionConfig.class);

	private static final String paramsRegex = "-[sSeEfF]";

	public static final String sourceUrl = "http://www.taifex.com.tw/chinese/3/7_12_5.asp";

	private LocalDate startDate = LocalDate.now().plusDays(-1);

	private LocalDate endDate = LocalDate.now();

	private boolean filterFI = true;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isFilterFI() {
		return filterFI;
	}

	public void setFilterFI(boolean isFilterFI) {
		this.filterFI = isFilterFI;
	}

	public Long getBetweenDays() {
		return ChronoUnit.DAYS.between(startDate, endDate);
	}

	public OptionConfig(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].matches(paramsRegex) && i + 1 > args.length) {
				throw new ParamsException("參數長度錯誤，請確認是否輸入正確。");
			}

			if ("-s".equalsIgnoreCase(args[i])) {
				if (!LocalDateUtils.vaildDate(args[i + 1])) {
					throw new ParamsException("起始日期參數錯誤，請確認是否輸入正確。");
				}

				this.startDate = LocalDate.parse(args[i]);
				if (this.startDate.isAfter(this.endDate)) {
					this.startDate = this.endDate.plusDays(-1);
					log.info("起始日期超過終止日，改設定為終止日前一天。");
				}
			} else if ("-e".equalsIgnoreCase(args[i])) {
				if (!LocalDateUtils.vaildDate(args[i + 1])) {
					throw new ParamsException("終止日期參數錯誤，請確認是否輸入正確。");
				}

				this.endDate = LocalDate.parse(args[i]);

				if (this.endDate.isAfter(LocalDate.now())) {
					this.endDate = LocalDate.now();
					log.info("終止日超過今天，終止日改設定為今天。");
				}

				if (this.startDate.isAfter(this.endDate)) {
					this.startDate = this.endDate.plusDays(-1);
					log.info("起始日期超過終止日，改設定為終止日前一天。");
				}

			} else if ("-f".equalsIgnoreCase(args[i])) {
				this.filterFI = "y".equalsIgnoreCase(args[i + 1]);
			}
		}
	}

}
