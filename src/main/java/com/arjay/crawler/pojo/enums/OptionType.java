package com.arjay.crawler.pojo.enums;

public enum OptionType {
	Call, Put;

	public static OptionType parseOf(String optionType) {
		return "買權".equals(optionType) ? Call : Put;
	}
}
