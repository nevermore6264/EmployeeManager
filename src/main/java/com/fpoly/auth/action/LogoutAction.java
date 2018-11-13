package com.fpoly.auth.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@ResultPath("/views/auth/")
public class LogoutAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Action(value = "logout", results = { @Result(name = SUCCESS, location = "login.jsp") })
	public String logOut() {
		session.remove("loginID");
		addActionMessage("You have been Successfully Logged Out");
		return SUCCESS;

	}

}
