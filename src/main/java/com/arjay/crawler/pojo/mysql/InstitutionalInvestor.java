package com.arjay.crawler.pojo.mysql;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.arjay.crawler.pojo.enums.Investor;
import com.arjay.crawler.pojo.enums.OptionType;

@Entity
public class InstitutionalInvestor implements Serializable {

	private static final long serialVersionUID = 7146346255317282781L;

	public final static String[] fields = { "日期", "權別", "身分別", "買方口數", "買方契約金額", "賣方口數", "賣方契約金額", "口數差額", "契約金差額",
			"未平倉買方口數", "未平倉買方契約金額", "未平倉賣方口數", "未平倉賣方契約金額", "未平倉口數差額", "未平倉契約金差額" };

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 日期
	 */
	@Column(name = "LOCAL_DATE")
	private LocalDate localDate;

	/**
	 * 權別
	 */
	@Column(name = "OPTION_TYPE")
	@Enumerated(EnumType.STRING)
	private OptionType optionType;

	/**
	 * 身分別
	 */
	@Enumerated(EnumType.STRING)
	private Investor investor;

	/**
	 * 買方口數
	 */
	@Column(name = "HOLDER_DEALT_LOT")
	private Long holderDealtLot;

	/**
	 * 買方契約金額
	 */
	@Column(name = "HOLDER_DEALT_AMOUNT")
	private Long holderDealtAmount;

	/**
	 * 賣方口數
	 */
	@Column(name = "SELLER_DEALT_LOT")
	private Long sellerDealtLot;

	/**
	 * 賣方契約金額
	 */
	@Column(name = "SELLER_DEALT_AMOUNT")
	private Long sellerDealtAmount;

	/**
	 * 口數差額
	 */
	@Column(name = "BALANCE_DEALT_LOT")
	private Long balanceDealtLot;

	/**
	 * 契約金差額
	 */
	@Column(name = "BALANCE_DEALT_AMOUNT")
	private Long balanceDealtAmount;

	/**
	 * 未平倉買方口數
	 */
	@Column(name = "HOLDER_KEEP_LOT")
	private Long holderKeepLot;

	/**
	 * 未平倉買方契約金額
	 */
	@Column(name = "HOLDER_KEEP_AMOUNT")
	private Long holderKeepAmount;

	/**
	 * 未平倉賣方口數
	 */
	@Column(name = "SELLER_KEEP_LOT")
	private Long sellerKeepLot;

	/**
	 * 未平倉賣方契約金額
	 */
	@Column(name = "SELLER_KEEP_AMOUNT")
	private Long sellerKeepAmount;

	/**
	 * 未平倉口數差額
	 */
	@Column(name = "BALANCE_KEEP_LOT")
	private Long balanceKeepLot;

	/**
	 * 未平倉契約金差額
	 */
	@Column(name = "BALANCE_KEEP_AMOUNT")
	private Long balanceKeepAmount;

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public OptionType getOptionType() {
		return optionType;
	}

	public void setOptionType(OptionType optionType) {
		this.optionType = optionType;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public Long getHolderDealtLot() {
		return holderDealtLot;
	}

	public void setHolderDealtLot(Long holderDealtLot) {
		this.holderDealtLot = holderDealtLot;
	}

	public Long getHolderDealtAmount() {
		return holderDealtAmount;
	}

	public void setHolderDealtAmount(Long holderDealtAmount) {
		this.holderDealtAmount = holderDealtAmount;
	}

	public Long getSellerDealtLot() {
		return sellerDealtLot;
	}

	public void setSellerDealtLot(Long sellerDealtLot) {
		this.sellerDealtLot = sellerDealtLot;
	}

	public Long getSellerDealtAmount() {
		return sellerDealtAmount;
	}

	public void setSellerDealtAmount(Long sellerDealtAmount) {
		this.sellerDealtAmount = sellerDealtAmount;
	}

	public Long getBalanceDealtLot() {
		return balanceDealtLot;
	}

	public void setBalanceDealtLot(Long balanceDealtLot) {
		this.balanceDealtLot = balanceDealtLot;
	}

	public Long getBalanceDealtAmount() {
		return balanceDealtAmount;
	}

	public void setBalanceDealtAmount(Long balanceDealtAmount) {
		this.balanceDealtAmount = balanceDealtAmount;
	}

	public Long getHolderKeepLot() {
		return holderKeepLot;
	}

	public void setHolderKeepLot(Long holderKeepLot) {
		this.holderKeepLot = holderKeepLot;
	}

	public Long getHolderKeepAmount() {
		return holderKeepAmount;
	}

	public void setHolderKeepAmount(Long holderKeepAmount) {
		this.holderKeepAmount = holderKeepAmount;
	}

	public Long getSellerKeepLot() {
		return sellerKeepLot;
	}

	public void setSellerKeepLot(Long sellerKeepLot) {
		this.sellerKeepLot = sellerKeepLot;
	}

	public Long getSellerKeepAmount() {
		return sellerKeepAmount;
	}

	public void setSellerKeepAmount(Long sellerKeepAmount) {
		this.sellerKeepAmount = sellerKeepAmount;
	}

	public Long getBalanceKeepLot() {
		return balanceKeepLot;
	}

	public void setBalanceKeepLot(Long balanceKeepLot) {
		this.balanceKeepLot = balanceKeepLot;
	}

	public Long getBalanceKeepAmount() {
		return balanceKeepAmount;
	}

	public void setBalanceKeepAmount(Long balanceKeepAmount) {
		this.balanceKeepAmount = balanceKeepAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Option [localDate=");
		builder.append(localDate);
		builder.append(", optionType=");
		builder.append(optionType);
		builder.append(", investor=");
		builder.append(investor);
		builder.append(", holderDealtLot=");
		builder.append(holderDealtLot);
		builder.append(", holderDealtAmount=");
		builder.append(holderDealtAmount);
		builder.append(", sellerDealtLot=");
		builder.append(sellerDealtLot);
		builder.append(", sellerDealtAmount=");
		builder.append(sellerDealtAmount);
		builder.append(", balanceDealtLot=");
		builder.append(balanceDealtLot);
		builder.append(", balanceDealtAmount=");
		builder.append(balanceDealtAmount);
		builder.append(", holderKeepLot=");
		builder.append(holderKeepLot);
		builder.append(", holderKeepAmount=");
		builder.append(holderKeepAmount);
		builder.append(", sellerKeepLot=");
		builder.append(sellerKeepLot);
		builder.append(", sellerKeepAmount=");
		builder.append(sellerKeepAmount);
		builder.append(", balanceKeepLot=");
		builder.append(balanceKeepLot);
		builder.append(", balanceKeepAmount=");
		builder.append(balanceKeepAmount);
		builder.append("]");
		return builder.toString();
	}

	public String toCsv() {
		StringBuilder builder = new StringBuilder();
		builder.append(localDate);
		builder.append(",");
		builder.append(optionType);
		builder.append(",");
		builder.append(investor);
		builder.append(",");
		builder.append(holderDealtLot);
		builder.append(",");
		builder.append(holderDealtAmount);
		builder.append(",");
		builder.append(sellerDealtLot);
		builder.append(",");
		builder.append(sellerDealtAmount);
		builder.append(",");
		builder.append(balanceDealtLot);
		builder.append(",");
		builder.append(balanceDealtAmount);
		builder.append(",");
		builder.append(holderKeepLot);
		builder.append(",");
		builder.append(holderKeepAmount);
		builder.append(",");
		builder.append(sellerKeepLot);
		builder.append(",");
		builder.append(sellerKeepAmount);
		builder.append(",");
		builder.append(balanceKeepLot);
		builder.append(",");
		builder.append(balanceKeepAmount);
		return builder.toString();
	}

}
