package com.akalea.ftx.domain;

public class FtxTriggerOrder {
	
	 private String          market;
	 private FtxPositionSide side;
	 private Double          triggerPrice;
	 private Double          size;
	 private FtxOrderType    type;
	 private boolean reduceOnly;
	 
	 public boolean isReduceOnly() {
		return reduceOnly;
	}
	public void setReduceOnly(boolean reduceOnly) {
		this.reduceOnly = reduceOnly;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public FtxPositionSide getSide() {
		return side;
	}
	public void setSide(FtxPositionSide side) {
		this.side = side;
	}
	public Double getTriggerPrice() {
		return triggerPrice;
	}
	public void setTriggerPrice(Double triggerPrice) {
		this.triggerPrice = triggerPrice;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public FtxOrderType getType() {
		return type;
	}
	public void setType(FtxOrderType type) {
		this.type = type;
	}
	
	 
}
