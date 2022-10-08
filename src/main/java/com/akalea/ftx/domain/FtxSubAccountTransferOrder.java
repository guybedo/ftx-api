package com.akalea.ftx.domain;

public class FtxSubAccountTransferOrder {
	private String coin;
	private Double size;
	private String source;
	private String destination;

	private FtxSubAccountTransferOrder() {

	}

	public static FtxSubAccountTransferOrder create() {
		return new FtxSubAccountTransferOrder();
	}

	public String getCoin() {
		return coin;
	}

	public FtxSubAccountTransferOrder setCoin(String coin) {
		this.coin = coin;
		return this;
	}

	public Double getSize() {
		return size;
	}

	public FtxSubAccountTransferOrder setSize(Double size) {
		this.size = size;
		return this;
	}

	public String getSource() {
		return source;
	}

	public FtxSubAccountTransferOrder setSource(String source) {
		this.source = source;
		return this;
	}

	public String getDestination() {
		return destination;
	}

	public FtxSubAccountTransferOrder setDestination(String destination) {
		this.destination = destination;
		return this;
	}

}
