package com.arjay.crawler.pojo;

public class OptionField {

	public final static String[] fields = { "日期", "權別", "身分別", "買方口數", "買方契約金額", "賣方口數", "賣方契約金額", "口數差額", "契約金差額",
			"未平倉買方口數", "未平倉買方契約金額", "未平倉賣方口數", "未平倉賣方契約金額", "未平倉口數差額", "未平倉契約金差額" };

	/**
	 * 權別
	 */
	public static int optionType = 0;

	/**
	 * 身分別
	 */
	public static int investor = 1;

	/**
	 * 買方口數
	 */
	public static int holderDealtLot = 2;

	/**
	 * 買方契約金額
	 */
	public static int holderDealtAmount = 3;

	/**
	 * 賣方口數
	 */
	public static int sellerDealtLot = 4;

	/**
	 * 賣方契約金額
	 */
	public static int sellerDealtAmount = 5;

	/**
	 * 口數差額
	 */
	public static int balanceDealtLot = 6;

	/**
	 * 契約金差額
	 */
	public static int balanceDealtAmount = 7;

	/**
	 * 未平倉買方口數
	 */
	public static int holderKeepLot = 8;

	/**
	 * 未平倉買方契約金額
	 */
	public static int holderKeepAmount = 9;

	/**
	 * 未平倉賣方口數
	 */
	public static int sellerKeepLot = 10;

	/**
	 * 未平倉賣方契約金額
	 */
	public static int sellerKeepAmount = 11;

	/**
	 * 未平倉口數差額
	 */
	public static int balanceKeepLot = 12;

	/**
	 * 未平倉契約金差額
	 */
	public static int balanceKeepAmount = 13;
}
