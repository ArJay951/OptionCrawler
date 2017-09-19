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
@Table(name = "FUTURES_DAILY")
public class FuturesDaily implements Serializable {

	private static final long serialVersionUID = 3034657173280530092L;

	public static String[] fields = { "契約", "到期月份(週別)", "開盤價", "最高價", "最低價", "最後成交價", "漲跌價", "漲跌%", "盤後交易時段成交量",
			"一般交易時段成交量", "合計成交量", "結算價", "未沖銷契約量", "最後最佳買價", "最後最佳賣價", "歷史最高價", "歷史最低價" };

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date date;

	private String contract;

	private String period;

	@Column(name = "OPENING_PRICE")
	private Integer openingPrice;

	@Column(name = "HIGHEST_PRICE")
	private Integer highestPrice;

	@Column(name = "LOWEST_PRICE")
	private Integer lowestPrice;

	@Column(name = "FINAL_PRICE")
	private Integer finalPrice;

	private Integer change;

	@Column(name = "CHANGE_PERCENT")
	private Float changePercent;

	@Column(name = "AFTER_TRADE_TIME_AMOUNT")
	private Integer afterTradeTimeAmount;

	@Column(name = "NORMAL_TRADE_TIME_AMOUNT")
	private Integer normalTradeTimeAmount;

	@Column(name = "TOTAL_AMOUNT")
	private Integer totalAmount;

	@Column(name = "SETTLEMENT_PRICE")
	private Integer settlementPrice;

	@Column(name = "OPEN_INTEREST")
	private Integer openInterest;

	@Column(name = "FINAL_BUY_PRICE")
	private Integer finalBuyPrice;

	@Column(name = "FINAL_SELL_PRICE")
	private Integer finalSellPrice;

	@Column(name = "HIGHEST_IN_HISTORY")
	private Integer highestInHistory;

	@Column(name = "LOWEST_IN_HISTORY")
	private Integer lowestInHistory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(Integer openingPrice) {
		this.openingPrice = openingPrice;
	}

	public Integer getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(Integer highestPrice) {
		this.highestPrice = highestPrice;
	}

	public Integer getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(Integer lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public Integer getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Integer getChange() {
		return change;
	}

	public void setChange(Integer change) {
		this.change = change;
	}

	public Float getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(Float changePercent) {
		this.changePercent = changePercent;
	}

	public Integer getAfterTradeTimeAmount() {
		return afterTradeTimeAmount;
	}

	public void setAfterTradeTimeAmount(Integer afterTradeTimeAmount) {
		this.afterTradeTimeAmount = afterTradeTimeAmount;
	}

	public Integer getNormalTradeTimeAmount() {
		return normalTradeTimeAmount;
	}

	public void setNormalTradeTimeAmount(Integer normalTradeTimeAmount) {
		this.normalTradeTimeAmount = normalTradeTimeAmount;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(Integer settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public Integer getOpenInterest() {
		return openInterest;
	}

	public void setOpenInterest(Integer openInterest) {
		this.openInterest = openInterest;
	}

	public Integer getFinalBuyPrice() {
		return finalBuyPrice;
	}

	public void setFinalBuyPrice(Integer finalBuyPrice) {
		this.finalBuyPrice = finalBuyPrice;
	}

	public Integer getFinalSellPrice() {
		return finalSellPrice;
	}

	public void setFinalSellPrice(Integer finalSellPrice) {
		this.finalSellPrice = finalSellPrice;
	}

	public Integer getHighestInHistory() {
		return highestInHistory;
	}

	public void setHighestInHistory(Integer highestInHistory) {
		this.highestInHistory = highestInHistory;
	}

	public Integer getLowestInHistory() {
		return lowestInHistory;
	}

	public void setLowestInHistory(Integer lowestInHistory) {
		this.lowestInHistory = lowestInHistory;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FuturesDaily [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", contract=");
		builder.append(contract);
		builder.append(", period=");
		builder.append(period);
		builder.append(", openingPrice=");
		builder.append(openingPrice);
		builder.append(", highestPrice=");
		builder.append(highestPrice);
		builder.append(", lowestPrice=");
		builder.append(lowestPrice);
		builder.append(", finalPrice=");
		builder.append(finalPrice);
		builder.append(", change=");
		builder.append(change);
		builder.append(", changePercent=");
		builder.append(changePercent);
		builder.append(", afterTradeTimeAmount=");
		builder.append(afterTradeTimeAmount);
		builder.append(", normalTradeTimeAmount=");
		builder.append(normalTradeTimeAmount);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", settlementPrice=");
		builder.append(settlementPrice);
		builder.append(", openInterest=");
		builder.append(openInterest);
		builder.append(", finalBuyPrice=");
		builder.append(finalBuyPrice);
		builder.append(", finalSellPrice=");
		builder.append(finalSellPrice);
		builder.append(", highestInHistory=");
		builder.append(highestInHistory);
		builder.append(", lowestInHistory=");
		builder.append(lowestInHistory);
		builder.append("]");
		return builder.toString();
	}

}
