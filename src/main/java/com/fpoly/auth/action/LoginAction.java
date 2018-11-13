package com.fpoly.auth.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.account.service.AccountService;
import com.fpoly.common.entities.Account;

@ResultPath("/views/auth/")
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private Account account;
	private String userName;
	private String password;
	private AccountService accountService;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Action(value = "loginInput", results = { @Result(name = INPUT, location = "login.jsp") })
	public String input() throws Exception {
		return INPUT;

	}

	@Action(value = "login", results = { @Result(name = SUCCESS, location = "account", type = "redirectAction"),
			@Result(name = INPUT, location = "login.jsp") })
	public String login() {
		if (accountService.checkAuth(userName, password)) {
			if (userName != null) {
				// save in session
				session.put("loginID", userName);
				return SUCCESS;
			}
		}
		addActionMessage("Login failed");
		return INPUT;
	}

}
