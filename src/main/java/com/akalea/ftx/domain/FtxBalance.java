package com.akalea.ftx.domain;

public class FtxBalance {

	private String coin;
	private Double free;
	private Double spotBorrow;
	private Double total;
	private Double usdValue;
	private Double availableWithoutBorrow;
	
	public String getCoin() {
		return coin;
	}
	public void setCoin(String coin) {
		this.coin = coin;
	}
	public Double getFree() {
		return free;
	}
	public void setFree(Double free) {
		this.free = free;
	}
	public Double getSpotBorrow() {
		return spotBorrow;
	}
	public void setSpotBorrow(Double spotBorrow) {
		this.spotBorrow = spotBorrow;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getUsdValue() {
		return usdValue;
	}
	public void setUsdValue(Double usdValue) {
		this.usdValue = usdValue;
	}
	public Double getAvailableWithoutBorrow() {
		return availableWithoutBorrow;
	}
	public void setAvailableWithoutBorrow(Double availableWithoutBorrow) {
		this.availableWithoutBorrow = availableWithoutBorrow;
	}
	
}
