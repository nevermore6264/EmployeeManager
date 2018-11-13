package com.fpoly.department.action;


import com.fpoly.department.dto.DepartmentDto;
import com.fpoly.department.form.DepartmentCreateForm;
import com.fpoly.department.service.DepartmentService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.department.dto.DepartmentDto;
import com.fpoly.department.form.DepartmentCreateForm;
import com.fpoly.department.service.DepartmentService;


@ResultPath("/views/department")
@InterceptorRef(value = "loginStack")
public class DepartmentCreateAction extends ActionSupport {

	/**
	 * 
	 */
	private DepartmentDto departmentDto;
	private DepartmentService departmentService;
	private DepartmentCreateForm departmentCreateForm;
	private String code;
	private static final long serialVersionUID = 1L;
	
	@Action(value = "inputCreateDepart" , results = {@Result(name = INPUT , location = "createDepartment.jsp" )})
	public String input() throws Exception {
		return INPUT;
	}
	
	@Action(value = "createDepart" , results = {@Result(name = SUCCESS , location = "department", type="redirectAction" ),
													@Result(name = INPUT , location = "createDepartment.jsp")})
	public String submit(){
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setId(departmentCreateForm.getId());
		departmentDto.setCode(departmentCreateForm.getCode());
		departmentDto.setNameDepart(departmentCreateForm.getNameDepart());
		if (departmentService.create(departmentDto)) {
			return SUCCESS;
		}
		
		return INPUT;
	}
	
	public void validate() {
		if(departmentCreateForm.getCode().length() == 0) {
			addFieldError("departmentCreateForm.code", getText("department.code.required"));
			
		}
		if(departmentCreateForm.getNameDepart().length() == 0) {
			addFieldError("departmentCreateForm.nameDepart", getText("department.name.required"));
		}
		if(departmentService.check(departmentCreateForm.getCode())) {
			addFieldError("departmentCreateForm.code", getText("department.code.exist"));
		}
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DepartmentCreateForm getDepartmentCreateForm() {
		return departmentCreateForm;
	}

	public void setDepartmentCreateForm(DepartmentCreateForm departmentCreateForm) {
		this.departmentCreateForm = departmentCreateForm;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	 
}
