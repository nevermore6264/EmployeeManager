package com.fpoly.employee.action;


import java.util.List;
import java.util.Map;

import com.fpoly.employee.dto.DepartmentDto;
import com.fpoly.employee.dto.EmployeeDto;
import com.fpoly.employee.form.EmployeeCreateForm;
import com.fpoly.employee.service.EmployeeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.employee.dto.DepartmentDto;
import com.fpoly.employee.dto.EmployeeDto;
import com.fpoly.employee.form.EmployeeCreateForm;
import com.fpoly.employee.service.EmployeeService;

@ResultPath("/views/employee/")
@InterceptorRef(value = "loginStack")
public class EmployeeCreateAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<DepartmentDto> listDepart;
	
	private EmployeeDto employeeDto;
	
	private EmployeeCreateForm form;
	
	private EmployeeService employeeService;
	
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	@Override
	@Action(value = "createEmployee", results = { @Result(name = INPUT, location = "createEmployee.jsp") })
	public String input() throws Exception {
		listDepart = employeeService.departmentDtos(null);
		return INPUT;
	}
	
	@Action(value = "createEmployeeSucces", results = { @Result(name = SUCCESS, location = "employee", type = "redirectAction"),
			@Result(name = INPUT, location = "createEmployee.jsp") })
	public String submit() {
		EmployeeDto employeeDto = new EmployeeDto();
				
		employeeDto.setCode(form.getCode());
		employeeDto.setNameStaff(form.getNameStaff());
		employeeDto.setGender(form.isGender());
		employeeDto.setBirthday(form.getBirthday());
		employeeDto.setPhoto(form.getPhoto());
		employeeDto.setEmail(form.getEmail());
		employeeDto.setPhone(form.getPhone());
		employeeDto.setSalary(form.getSalary());
		employeeDto.setNote(form.getNote());
		employeeDto.setIdDepart(form.getIdDepart());
	if (employeeService.create(employeeDto)) {
		listDepart = employeeService.departmentDtos(null);
		session.put("sessionMessageDto", getText("message.create.success"));
		return SUCCESS;
	}
		return INPUT;
	}
	
	public void validate() {
		 
		if  (employeeService.check(form.getCode())) {
			addFieldError("form.code",getText("code.required.check"));
		}else if (form.getCode().length() == 0) {
			addFieldError("form.code", getText("required"));
		}
		if (form.getNameStaff().length() == 0) {
			addFieldError("form.nameStaff", getText("required"));
		}
		if (form.getBirthday().length() == 0) {
			addFieldError("form.birthday", getText("required"));
		}
		if (form.getEmail().length() == 0) {
			addFieldError("form.email", getText("required"));
		}
		if (form.getPhone().length() == 0) {
			addFieldError("form.phone", getText("required"));
		}
		if (form.getNote().length() == 0) {
			addFieldError("form.note", getText("required"));
		}
		listDepart = employeeService.departmentDtos(null);
	}

	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}


	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	public EmployeeCreateForm getForm() {
		return form;
	}
	
	
	public void setForm(EmployeeCreateForm form) {
		this.form = form;
	}


	public EmployeeService getEmployeeService() {
		return employeeService;
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<DepartmentDto> getListDepart() {
		return listDepart;
	}


	public void setListDepart(List<DepartmentDto> listDepart) {
		this.listDepart = listDepart;
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
