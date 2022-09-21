package com.akalea.ftx.domain;

public class FtxSubAccountTransfer {
	private Long id;
	private String coin;
	private Double size;
	private String time;
	private String notes;
	private String status;

	private FtxSubAccountTransfer() {

	}

	public static FtxSubAccountTransfer create() {
		return new FtxSubAccountTransfer();
	}

	public Long getId() {
		return id;
	}

	public FtxSubAccountTransfer setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCoin() {
		return coin;
	}

	public FtxSubAccountTransfer setCoin(String coin) {
		this.coin = coin;
		return this;
	}

	public Double getSize() {
		return size;
	}

	public FtxSubAccountTransfer setSize(Double size) {
		this.size = size;
		return this;
	}

	public String getTime() {
		return time;
	}

	public FtxSubAccountTransfer setTime(String time) {
		this.time = time;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public FtxSubAccountTransfer setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public FtxSubAccountTransfer setStatus(String status) {
		this.status = status;
		return this;
	}

}
