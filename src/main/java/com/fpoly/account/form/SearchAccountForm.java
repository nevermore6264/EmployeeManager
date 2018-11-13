/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Aug 16, 2018
 */
package com.fpoly.account.form;

public class SearchAccountForm {
	private String username;
	private Long page;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

}
