/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Jul 25, 2018
 */
package com.fpoly.account.action;


import java.util.Map;

import com.fpoly.account.service.AccountService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.account.service.AccountService;

@ResultPath("/views/account/")
@InterceptorRef(value = "loginStack")
public class AccountRemoveAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
	private Long id;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "account", type = "redirect") })
	public String removeAccount() {
		accountService.deleteAccount(id);
		session.put("sessionMessageDto", getText("message.delete.success"));
		return SUCCESS;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	
	

}
