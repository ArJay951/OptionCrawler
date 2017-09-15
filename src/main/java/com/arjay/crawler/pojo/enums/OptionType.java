package com.arjay.crawler.pojo.enums;

public enum OptionType {
	Call, Put;

	public static OptionType parseOf(String optionType) {
		return "�R�v".equals(optionType) ? Call : Put;
	}
}
