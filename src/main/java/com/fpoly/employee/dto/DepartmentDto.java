package com.fpoly.employee.dto;

public class DepartmentDto {
	
	private Long id;
	
	private String code;

	private String nameDepart;
	
	
	public DepartmentDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameDepart() {
		return nameDepart;
	}

	public void setNameDepart(String nameDepart) {
		this.nameDepart = nameDepart;
	}

	
	
	
}
