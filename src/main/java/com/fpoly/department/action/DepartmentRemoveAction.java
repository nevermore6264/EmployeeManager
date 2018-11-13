package com.fpoly.department.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.department.dto.DepartmentDto;
import com.fpoly.department.service.DepartmentService;

@ResultPath("/views/department")
@InterceptorRef(value = "loginStack")
public class DepartmentRemoveAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DepartmentService departmentService;
	private DepartmentDto departmentDto;
	private Long id;
	
	
	@Action(value = "removeDepart" , results = {@Result(name = SUCCESS, location = "department" , type="redirectAction")})
	public String removeDepart() {
		
		departmentService.remove(id);
		return SUCCESS;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
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

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}
	
	
}
