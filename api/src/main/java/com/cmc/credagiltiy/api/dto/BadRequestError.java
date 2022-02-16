package com.cmc.credagiltiy.api.dto;

public class BadRequestError {

	private String error;

	public BadRequestError(String error) {
		this.error = error;
	}

	public String getError() {
		return this.error;
	}
}
