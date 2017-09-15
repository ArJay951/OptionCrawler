package com.arjay.crawler.pojo.enums;

public enum Investor {
	/**
	 * 散戶<BR>
	 * Retail Investors
	 */
	RI("Retail Investors", "散戶"),
	/**
	 * 外資<BR>
	 * Foreign Investor
	 */
	FI("Foreign Investor", "外資"),
	/**
	 * 
	 * 投信<BR>
	 * Domestic Institution
	 */
	DI("Domestic Institution", "投信"),
	/**
	 * 自營商<BR>
	 * Dealer
	 */
	DEALER("Dealer", "自營商");

	private String investor;

	private String chinese;

	private Investor(String investor, String chinese) {
		this.investor = investor;
		this.chinese = chinese;
	}

	public String getChinese() {
		return this.chinese;
	}

	public String getValue() {
		return this.investor;
	}

	public static Investor parseOf(String investor) {
		if ("自營商".equals(investor)) {
			return DEALER;
		} else if ("投信".equals(investor)) {
			return DI;
		} else if ("外資".equals(investor)) {
			return FI;
		}
		return null;
	}
}
