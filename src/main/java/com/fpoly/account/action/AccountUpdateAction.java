package com.fpoly.account.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.account.dto.AccountDto;
import com.fpoly.account.form.UpdateAccountForm;
import com.fpoly.account.service.AccountService;

@ResultPath("/views/account/")
@InterceptorRef(value = "loginStack")
public class AccountUpdateAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
	private AccountDto form;
	private UpdateAccountForm formUpdateAccount;
	private Long id;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public AccountDto getForm() {
		return form;
	}

	public void setForm(AccountDto form) {
		this.form = form;
	}

	public UpdateAccountForm getFormUpdateAccount() {
		return formUpdateAccount;
	}

	public void setFormUpdateAccount(UpdateAccountForm formUpdateAccount) {
		this.formUpdateAccount = formUpdateAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Action(value = "update", results = { @Result(name = INPUT, location = "updateAccount.jsp") })
	public String input() {
		form = accountService.findOne(id);
		return INPUT;
	}

	@Action(value = "updateAcc", results = { @Result(name = SUCCESS, location = "account", type = "redirectAction"),
			@Result(name = INPUT, location = "updateAccount.jsp") })
	public String submit() {
		form.setId(id);
		if (accountService.update(form)) {
			session.put("sessionMessageDto", getText("message.update.success"));
			return SUCCESS;
		} else {
			return INPUT;
		}

	}

	public void validate() {
		// check name
		if (form.getUsername().length() == 0) {
			addFieldError("form.username", getText("username.required"));
		}
		if (form.getPassword().length() == 0) {
			addFieldError("form.password", getText("username.password"));
		}
		if (form.getFullname().length() == 0) {
			addFieldError("form.fullname", getText("username.fullname"));
		}

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
