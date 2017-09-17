package com.arjay.crawler.pojo.mysql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LARGEAMOUNT_INVESTOR")
public class LargeAmountInvestor implements Serializable {

	private static final long serialVersionUID = -3375209939449240419L;

	public final static String[] fields = { "日期", "契約名稱", "到期月份(週別)", "前五買方部位數", "前五特定法人買方部位數", "前五買方百分比",
			"前五特定法人買方百分比", "前十買方部位數", "前十特定法人買方部位數", "前十買方百分比", "前十特定法人買方百分比", "前五賣方部位數", "前五特定法人賣方部位數", "前五賣方百分比",
			"前五特定法人賣方百分比", "前十賣方部位數", "前十特定法人賣方部位數", "前十賣方百分比", "前十特定法人賣方百分比", "全市場未沖銷部位數" };
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 日期
	 */
	@Column(name="LOCAL_DATE")
	private Date localDate;

	/**
	 * 契約名稱
	 */
	@Column(name="CONTRACT_NAME")
	private String contractName;

	/**
	 * 到期月份(週別)
	 */
	private String period;

	/**
	 * 前五買方部位數
	 */
	@Column(name="TOP5_HOLDER_LOT")
	private Integer top5HolderLot;

	/**
	 * 特定法人前五買方部位數
	 */
	@Column(name="SPECIAL_TOP5_HOLDER_LOT")
	private Integer specialTop5HolderLot;

	/**
	 * 前五買方百分比
	 */
	@Column(name="TOP5_HOLDER_PERCENT")
	private Float top5HolderPercent;

	/**
	 * 特定法人前五買方百分比
	 */
	@Column(name="SPECIAL_TOP5_HOLDER_PERCENT")
	private Float specialTop5HolderPercent;

	/**
	 * 前十買方部位數
	 */
	@Column(name="TOP10_HOLDER_LOT")
	private Integer top10HolderLot;

	/**
	 * 特定法人前十買方部位數
	 */
	@Column(name="SPECIAL_TOP10_HOLDER_LOT")
	private Integer specialTop10HolderLot;

	/**
	 * 前十買方百分比
	 */
	@Column(name="TOP10_HOLDER_PERCENT")
	private Float top10HolderPercent;

	/**
	 * 特定法人前十買方百分比
	 */
	@Column(name="SPECIAL_TOP10_HOLDER_PERCENT")
	private Float specialTop10HolderPercent;

	/**
	 * 前五賣方部位數
	 */
	@Column(name="TOP5_SELLER_LOT")
	private Integer top5SellerLot;

	/**
	 * 特定法人前五賣方部位數
	 */
	@Column(name="SPECIAL_TOP5_SELLER_LOT")
	private Integer specialTop5SellerLot;

	/**
	 * 前五賣方百分比
	 */
	@Column(name="TOP5_SELLER_PERCENT")
	private Float top5SellerPercent;

	/**
	 * 特定法人前五賣方百分比
	 */
	@Column(name="SPECIAL_TOP5_SELLER_PERCENT")
	private Float specialTop5SellerPercent;

	/**
	 * 前十賣方部位數
	 */
	@Column(name="TOP10_SELLER_LOT")
	private Integer top10SellerLot;

	/**
	 * 特定法人前十賣方部位數
	 */
	@Column(name="SPECIAL_TOP10_SELLER_LOT")
	private Integer specialTop10SellerLot;

	/**
	 * 前十賣方百分比
	 */
	@Column(name="TOP10_SELLER_PERCENT")
	private Float top10SellerPercent;

	/**
	 * 特定法人前十賣方百分比
	 */
	@Column(name="SPECIAL_TOP10_SELLER_PERCENT")
	private Float specialTop10SellerPercent;

	/**
	 * 全市場未沖銷部位數
	 */
	@Column(name = "BALANCE_KEEP_LOT")
	private Integer balanceKeepLot;

	public Date getLocalDate() {
		return localDate;
	}

	public void setLocalDate(Date localDate) {
		this.localDate = localDate;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getTop5HolderLot() {
		return top5HolderLot;
	}

	public void setTop5HolderLot(Integer top5HolderLot) {
		this.top5HolderLot = top5HolderLot;
	}

	public Integer getSpecialTop5HolderLot() {
		return specialTop5HolderLot;
	}

	public void setSpecialTop5HolderLot(Integer specialTop5HolderLot) {
		this.specialTop5HolderLot = specialTop5HolderLot;
	}

	public Float getTop5HolderPercent() {
		return top5HolderPercent;
	}

	public void setTop5HolderPercent(Float top5HolderPercent) {
		this.top5HolderPercent = top5HolderPercent;
	}

	public Float getSpecialTop5HolderPercent() {
		return specialTop5HolderPercent;
	}

	public void setSpecialTop5HolderPercent(Float specialTop5HolderPercent) {
		this.specialTop5HolderPercent = specialTop5HolderPercent;
	}

	public Integer getTop10HolderLot() {
		return top10HolderLot;
	}

	public void setTop10HolderLot(Integer top10HolderLot) {
		this.top10HolderLot = top10HolderLot;
	}

	public Integer getSpecialTop10HolderLot() {
		return specialTop10HolderLot;
	}

	public void setSpecialTop10HolderLot(Integer specialTop10HolderLot) {
		this.specialTop10HolderLot = specialTop10HolderLot;
	}

	public Float getTop10HolderPercent() {
		return top10HolderPercent;
	}

	public void setTop10HolderPercent(Float top10HolderPercent) {
		this.top10HolderPercent = top10HolderPercent;
	}

	public Float getSpecialTop10HolderPercent() {
		return specialTop10HolderPercent;
	}

	public void setSpecialTop10HolderPercent(Float specialTop10HolderPercent) {
		this.specialTop10HolderPercent = specialTop10HolderPercent;
	}

	public Integer getTop5SellerLot() {
		return top5SellerLot;
	}

	public void setTop5SellerLot(Integer top5SellerLot) {
		this.top5SellerLot = top5SellerLot;
	}

	public Integer getSpecialTop5SellerLot() {
		return specialTop5SellerLot;
	}

	public void setSpecialTop5SellerLot(Integer specialTop5SellerLot) {
		this.specialTop5SellerLot = specialTop5SellerLot;
	}

	public Float getTop5SellerPercent() {
		return top5SellerPercent;
	}

	public void setTop5SellerPercent(Float top5SellerPercent) {
		this.top5SellerPercent = top5SellerPercent;
	}

	public Float getSpecialTop5SellerPercent() {
		return specialTop5SellerPercent;
	}

	public void setSpecialTop5SellerPercent(Float specialTop5SellerPercent) {
		this.specialTop5SellerPercent = specialTop5SellerPercent;
	}

	public Integer getTop10SellerLot() {
		return top10SellerLot;
	}

	public void setTop10SellerLot(Integer top10SellerLot) {
		this.top10SellerLot = top10SellerLot;
	}

	public Integer getSpecialTop10SellerLot() {
		return specialTop10SellerLot;
	}

	public void setSpecialTop10SellerLot(Integer specialTop10SellerLot) {
		this.specialTop10SellerLot = specialTop10SellerLot;
	}

	public Float getTop10SellerPercent() {
		return top10SellerPercent;
	}

	public void setTop10SellerPercent(Float top10SellerPercent) {
		this.top10SellerPercent = top10SellerPercent;
	}

	public Float getSpecialTop10SellerPercent() {
		return specialTop10SellerPercent;
	}

	public void setSpecialTop10SellerPercent(Float specialTop10SellerPercent) {
		this.specialTop10SellerPercent = specialTop10SellerPercent;
	}

	public Integer getBalanceKeepLot() {
		return balanceKeepLot;
	}

	public void setBalanceKeepLot(Integer balanceKeepLot) {
		this.balanceKeepLot = balanceKeepLot;
	}

	public static String[] getFields() {
		return fields;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LargeAmountInvestor [localDate=");
		builder.append(localDate);
		builder.append(", contractName=");
		builder.append(contractName);
		builder.append(", period=");
		builder.append(period);
		builder.append(", top5HolderLot=");
		builder.append(top5HolderLot);
		builder.append(", specialTop5HolderLot=");
		builder.append(specialTop5HolderLot);
		builder.append(", top5HolderPercent=");
		builder.append(top5HolderPercent);
		builder.append(", specialTop5HolderPercent=");
		builder.append(specialTop5HolderPercent);
		builder.append(", top10HolderLot=");
		builder.append(top10HolderLot);
		builder.append(", specialTop10HolderLot=");
		builder.append(specialTop10HolderLot);
		builder.append(", top10HolderPercent=");
		builder.append(top10HolderPercent);
		builder.append(", specialTop10HolderPercent=");
		builder.append(specialTop10HolderPercent);
		builder.append(", top5SellerLot=");
		builder.append(top5SellerLot);
		builder.append(", specialTop5SellerLot=");
		builder.append(specialTop5SellerLot);
		builder.append(", top5SellerPercent=");
		builder.append(top5SellerPercent);
		builder.append(", specialTop5SellerPercent=");
		builder.append(specialTop5SellerPercent);
		builder.append(", top10SellerLot=");
		builder.append(top10SellerLot);
		builder.append(", specialTop10SellerLot=");
		builder.append(specialTop10SellerLot);
		builder.append(", top10SellerPercent=");
		builder.append(top10SellerPercent);
		builder.append(", specialTop10SellerPercent=");
		builder.append(specialTop10SellerPercent);
		builder.append(", balanceKeepLot=");
		builder.append(balanceKeepLot);
		builder.append("]");
		return builder.toString();
	}

	public String toCsv() {
		StringBuilder builder = new StringBuilder();
		builder.append(localDate);
		builder.append(",");
		builder.append(contractName);
		builder.append(",");
		builder.append(period);
		builder.append(",");
		builder.append(top5HolderLot);
		builder.append(",");
		builder.append(specialTop5HolderLot);
		builder.append(",");
		builder.append(top5HolderPercent);
		builder.append("%,");
		builder.append(specialTop5HolderPercent);
		builder.append("%,");
		builder.append(top10HolderLot);
		builder.append(",");
		builder.append(specialTop10HolderLot);
		builder.append(",");
		builder.append(top10HolderPercent);
		builder.append("%,");
		builder.append(specialTop10HolderPercent);
		builder.append("%,");
		builder.append(top5SellerLot);
		builder.append(",");
		builder.append(specialTop5SellerLot);
		builder.append(",");
		builder.append(top5SellerPercent);
		builder.append("%,");
		builder.append(specialTop5SellerPercent);
		builder.append("%,");
		builder.append(top10SellerLot);
		builder.append(",");
		builder.append(specialTop10SellerLot);
		builder.append(",");
		builder.append(top10SellerPercent);
		builder.append("%,");
		builder.append(specialTop10SellerPercent);
		builder.append("%,");
		builder.append(balanceKeepLot);
		return builder.toString();
	}

}
