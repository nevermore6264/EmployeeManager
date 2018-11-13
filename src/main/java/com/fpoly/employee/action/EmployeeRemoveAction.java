package com.fpoly.employee.action;

import java.util.Map;

import com.fpoly.employee.service.EmployeeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.employee.service.EmployeeService;

@ResultPath("/views/employee/")
@InterceptorRef(value = "loginStack")
public class EmployeeRemoveAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	private Long id;
	
	
	@Action(value = "removeEmployee", results = { @Result(name = SUCCESS, location = "employee", type = "redirect"),
			@Result(name = INPUT, location = "employee", type = "redirect") })
	public String removeEmployee() {
		try {
			employeeService.remove(id);
			session.put("sessionMessageDto", getText("message.delete.success"));
			return SUCCESS;
		} catch (Exception e) {
			session.put("sessionMessageDto", getText("message.delete.faill"));
			return INPUT;
		}
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	
	
	
}
