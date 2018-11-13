package com.fpoly.employee.action;

import java.util.List;
import java.util.Map;

import com.fpoly.employee.dto.DepartmentDto;
import com.fpoly.employee.dto.EmployeeDto;
import com.fpoly.employee.form.EmployeeUpdateForm;
import com.fpoly.employee.service.EmployeeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import vn.poly.sof305.group1.employee.dto.DepartmentDto;
import vn.poly.sof305.group1.employee.dto.EmployeeDto;
import vn.poly.sof305.group1.employee.form.EmployeeUpdateForm;
import vn.poly.sof305.group1.employee.service.EmployeeService;

@ResultPath("/views/employee/")
@InterceptorRef(value = "loginStack")
public class EmployeeUpdateAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private List<DepartmentDto> listDepart;
	private EmployeeDto form;
	private EmployeeUpdateForm employeeUpdateForm;
	private EmployeeService employeeService;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	@Override
	@Action(value = "updateEmployee", results = { @Result(name = INPUT, location = "updateEmployee.jsp") })
	public String input() throws Exception {
		form = employeeService.detail(id);
		listDepart = employeeService.departmentDtos(null);
		return INPUT;
	}
	
	@Action(value = "updateEmployeeSucces", results = { @Result(name = SUCCESS, location = "employee", type = "redirectAction"),
			@Result(name = INPUT, location = "updateEmployee.jsp") })
	public String submit() {
		
		form.setId(id);
		listDepart = employeeService.departmentDtos(null);
		if (employeeService.update(form)) {
			session.put("sessionMessageDto", getText("message.update.success"));
			return SUCCESS;
		}
		return INPUT;
	}

	/**
	 * @return the form
	 */
	public EmployeeDto getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(EmployeeDto form) {
		this.form = form;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public List<DepartmentDto> getListDepart() {
		return listDepart;
	}

	public void setListDepart(List<DepartmentDto> listDepart) {
		this.listDepart = listDepart;
	}

	public EmployeeUpdateForm getEmployeeUpdateForm() {
		return employeeUpdateForm;
	}

	public void setEmployeeUpdateForm(EmployeeUpdateForm employeeUpdateForm) {
		this.employeeUpdateForm = employeeUpdateForm;
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
