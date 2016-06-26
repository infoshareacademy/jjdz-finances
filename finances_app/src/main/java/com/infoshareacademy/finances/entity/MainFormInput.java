package com.infoshareacademy.finances.entity;

import javax.persistence.*;

@Embeddable
public class MainFormInput {

	@Column(nullable = false)
    private String assetCode;

	@Column(nullable = false)
	private Long userId;

	private String month;
    private String year;

    public MainFormInput() {
    }

	public MainFormInput(String assetCode, Long userId, String month, String year) {
		this.assetCode = assetCode;
		this.userId = userId;
		this.month = month;
		this.year = year;
	}
}
