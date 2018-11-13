/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Jul 24, 2018
 */
package com.fpoly.interceptor;


import com.fpoly.account.dto.AccountDto;
import com.fpoly.account.service.AccountService;
import com.fpoly.auth.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import com.fpoly.account.dto.AccountDto;
import com.fpoly.account.service.AccountService;
import com.fpoly.auth.action.LoginAction;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
	private Long id = 1L;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	
	  @Override 
	  public String intercept(ActionInvocation invocation) throws Exception { 
		  // get session user Object user =
		  Object user = ActionContext.getContext().getSession().get("loginID");
			if (user != null) {		
				AccountDto dbUser = accountService.findOne(id);
				if (dbUser != null) {
					// in login page
					// if loged redirect to admin home page
					if (invocation.getAction() instanceof LoginAction)
						return ActionSupport.SUCCESS;

					return invocation.invoke();
				}
			}

			// skip redirect in login
			if (invocation.getAction() instanceof LoginAction)
				return invocation.invoke();

			// redirect login global
			return ActionSupport.LOGIN;
		}
	 
}
