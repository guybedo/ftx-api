package com.akalea.ftx.domain;

public class FtxCancelOrder {

	private String market;
	private FtxPositionSide side;
	private Boolean conditionalOrdersOnly;
	private Boolean limitOrdersOnly;

	public static FtxCancelOrder createNewOrder(String market, FtxPositionSide side, Boolean conditionalOrdersOnly,
			Boolean limitOrdersOnly) {
		return new FtxCancelOrder().setMarket(market).setSide(side).setConditionalOrdersOnly(conditionalOrdersOnly)
				.setLimitOrdersOnly(limitOrdersOnly);
	}

	public String getMarket() {
		return market;
	}

	public FtxCancelOrder setMarket(String market) {
		this.market = market;
		return this;
	}

	public FtxPositionSide getSide() {
		return side;
	}

	public FtxCancelOrder setSide(FtxPositionSide side) {
		this.side = side;
		return this;
	}

	public Boolean getConditionalOrdersOnly() {
		return conditionalOrdersOnly;
	}

	public FtxCancelOrder setConditionalOrdersOnly(Boolean conditionalOrdersOnly) {
		this.conditionalOrdersOnly = conditionalOrdersOnly;
		return this;
	}

	public Boolean getLimitOrdersOnly() {
		return limitOrdersOnly;
	}

	public FtxCancelOrder setLimitOrdersOnly(Boolean limitOrdersOnly) {
		this.limitOrdersOnly = limitOrdersOnly;
		return this;
	}

}
