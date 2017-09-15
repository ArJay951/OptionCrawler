package com.arjay.crawler.pojo.enums;

public enum Investor {
	/**
	 * ����<BR>
	 * Retail Investors
	 */
	RI("Retail Investors", "����"),
	/**
	 * �~��<BR>
	 * Foreign Investor
	 */
	FI("Foreign Investor", "�~��"),
	/**
	 * 
	 * ��H<BR>
	 * Domestic Institution
	 */
	DI("Domestic Institution", "��H"),
	/**
	 * �����<BR>
	 * Dealer
	 */
	DEALER("Dealer", "�����");

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
		if ("�����".equals(investor)) {
			return DEALER;
		} else if ("��H".equals(investor)) {
			return DI;
		} else if ("�~��".equals(investor)) {
			return FI;
		}
		return null;
	}
}
