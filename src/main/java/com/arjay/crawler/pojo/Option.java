package com.arjay.crawler.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import com.arjay.crawler.pojo.enums.Investor;
import com.arjay.crawler.pojo.enums.OptionType;

public class Option implements Serializable {

	private static final long serialVersionUID = 7146346255317282781L;

	/**
	 * ���
	 */
	private LocalDate localDate;

	/**
	 * �v�O
	 */
	private OptionType optionType;

	/**
	 * �����O
	 */
	private Investor investor;

	/**
	 * �R��f��
	 */
	private Long holderDealtLot;

	/**
	 * �R�諴�����B
	 */
	private Long holderDealtAmount;

	/**
	 * ���f��
	 */
	private Long sellerDealtLot;

	/**
	 * ��諴�����B
	 */
	private Long sellerDealtAmount;

	/**
	 * �f�Ʈt�B
	 */
	private Long balanceDealtLot;

	/**
	 * �������t�B
	 */
	private Long balanceDealtAmount;

	/**
	 * �����ܶR��f��
	 */
	private Long holderKeepLot;

	/**
	 * �����ܶR�諴�����B
	 */
	private Long holderKeepAmount;

	/**
	 * �����ܽ��f��
	 */
	private Long sellerKeepLot;

	/**
	 * �����ܽ�諴�����B
	 */
	private Long sellerKeepAmount;

	/**
	 * �����ܤf�Ʈt�B
	 */
	private Long balanceKeepLot;

	/**
	 * �����ܫ������t�B
	 */
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
		builder.append(investor.getChinese());
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
