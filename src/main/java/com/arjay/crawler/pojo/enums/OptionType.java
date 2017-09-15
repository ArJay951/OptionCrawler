package com.arjay.crawler.pojo.enums;

public enum OptionType {
	Call, Put;

	public static OptionType parseOf(String optionType) {
		return "¶RÅv".equals(optionType) ? Call : Put;
	}
}
