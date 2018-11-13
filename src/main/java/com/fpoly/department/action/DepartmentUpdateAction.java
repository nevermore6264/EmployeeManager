package com.fpoly.department.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.department.dto.DepartmentDto;
import com.fpoly.department.form.DepartmentUpdateForm;
import com.fpoly.department.service.DepartmentService;
@ResultPath("/views/department")
@InterceptorRef(value = "loginStack")
public class DepartmentUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private DepartmentService departmentService;
	private DepartmentDto departmentDto;
	private DepartmentUpdateForm departmentUpdateForm;
	private Long id;
	private static final long serialVersionUID = 1L;

	@Action(value = "inputUpdateDepart" , results = {@Result(name=SUCCESS , location="updateDepartment.jsp")})
	public String input() throws Exception {
		departmentDto = departmentService.selectId(id);
		return SUCCESS;
	}
	
	
	@Action(value = "updateDepart" , results = {@Result(name=SUCCESS , location="department" , type="redirectAction"),
												@Result(name = INPUT, location = "updateDepartment.jsp")})
	public String submit() {
		departmentDto.setId(id);
		
		if (departmentService.update(departmentDto)) {
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void validate() {
		if(departmentDto.getCode().isEmpty()) {
			this.addFieldError("departmentDto.code", "Không được để trống");
			
		}
		
		if(departmentDto.getNameDepart().isEmpty()) {
			this.addFieldError("departmentDto.nameDepart", "Không được để trống");
			
		}
		
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	public DepartmentUpdateForm getDepartmentUpdateForm() {
		return departmentUpdateForm;
	}

	public void setDepartmentUpdateForm(DepartmentUpdateForm departmentUpdateForm) {
		this.departmentUpdateForm = departmentUpdateForm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
