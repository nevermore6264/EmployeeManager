package com.fpoly.account.action;

import java.util.Map;

import com.fpoly.account.form.CreateAccountForm;
import com.fpoly.account.service.AccountService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.account.dto.AccountDto;
import com.fpoly.account.form.CreateAccountForm;
import com.fpoly.account.service.AccountService;

@ResultPath("/views/account/")
@InterceptorRef(value = "loginStack")
public class AccountCreateAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
	private CreateAccountForm form;
	private String username;

	private Map<String, Object> session = ActionContext.getContext().getSession();

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public CreateAccountForm getForm() {
		return form;
	}

	public void setForm(CreateAccountForm form) {
		this.form = form;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Action(value = "createAccount", results = { @Result(name = INPUT, location = "createAccount.jsp") })
	public String input() throws Exception {

		return INPUT;
	}

	@Action(value = "createAcc", results = { @Result(name = SUCCESS, location = "account", type = "redirectAction"),
			@Result(name = INPUT, location = "createAccount.jsp") })
	public String submit() {

		AccountDto accountDto = new AccountDto();
		accountDto.setId(form.getId());
		accountDto.setUsername(form.getUsername());
		accountDto.setPassword(form.getPassword());
		accountDto.setFullname(form.getFullname());
		if (accountService.add(accountDto)) {
			session.put("sessionMessageDto", getText("message.create.success"));
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public void validate() {
		// check name
		if (accountService.checkUsers(form.getUsername())) {
			addFieldError("form.username", getText("username.required.check"));
		} else if (form.getUsername().length() == 0) {
			addFieldError("form.username", getText("username.required"));
		}
		if (form.getPassword().length() == 0) {
			addFieldError("form.password", getText("password.required"));
		}
		if (form.getFullname().length() == 0) {
			addFieldError("form.fullname", getText("fullname.required"));
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub

	}
}
