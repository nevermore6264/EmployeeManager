package com.fpoly.employee.action;

import java.util.List;

import com.fpoly.common.dto.ListDataDto;
import com.fpoly.common.dto.ListPagingDto;
import com.fpoly.common.utils.DataTransformUtil;
import com.fpoly.employee.dto.DepartmentDto;
import com.fpoly.employee.dto.EmployeeDto;
import com.fpoly.employee.form.EmployeeListForm;
import com.fpoly.employee.service.EmployeeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import vn.poly.sof305.group1.common.dto.ListDataDto;
import vn.poly.sof305.group1.common.dto.ListPagingDto;
import vn.poly.sof305.group1.common.utils.DataTransformUtil;
import vn.poly.sof305.group1.employee.dto.DepartmentDto;
import vn.poly.sof305.group1.employee.dto.EmployeeDto;
import vn.poly.sof305.group1.employee.form.EmployeeListForm;
import vn.poly.sof305.group1.employee.service.EmployeeService;

@ResultPath("/views/employee/")
@InterceptorRef(value = "loginStack")
public class EmployeeListAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<EmployeeDto> listEmp;
	private EmployeeService employeeService;
	private EmployeeDto employeeDto;
	
	private com.fpoly.common.dto.ListDataDto<EmployeeDto> ListDataDto = new ListDataDto<>();
	private ListPagingDto pagination;
	private List<DepartmentDto> departmentDto;
	private Long idDepart;
	private String nameStaff;
	private Long pn;
	@Override
	@Action(value = "employee", results = { @Result(name = SUCCESS, location = "listEmployee.jsp") })
	public String input()  {
		EmployeeDto employeeDto = new EmployeeDto();
		EmployeeListForm employeeListForm = (EmployeeListForm) DataTransformUtil.transform(employeeDto,
				EmployeeListForm.class);
		employeeListForm.setPn(pn);
		employeeListForm.setIdDepart(idDepart);
		employeeListForm.setNameStaff(nameStaff);

		if (pn != null) {
			ListDataDto = employeeService.listEmp(idDepart, nameStaff, pn);
		} else
		ListDataDto = employeeService.listEmp(idDepart, nameStaff,  pn = 1L);
		listEmp = ListDataDto.getList();
		pagination = ListDataDto.getPaging();
		departmentDto = employeeService.departmentDtos(null);
		return SUCCESS;
	}
	
	/**
	 * @return the employeeDto
	 */
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	/**
	 * @param employeeDto the employeeDto to set
	 */
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	/**
	 * @return the listDataDto
	 */
	public ListDataDto<EmployeeDto> getListDataDto() {
		return ListDataDto;
	}

	/**
	 * @param listDataDto the listDataDto to set
	 */
	public void setListDataDto(ListDataDto<EmployeeDto> listDataDto) {
		ListDataDto = listDataDto;
	}

	/**
	 * @return the paging
	 */


	/**
	 * @return the departmentDto
	 */
	public List<DepartmentDto> getDepartmentDto() {
		return departmentDto;
	}

	public ListPagingDto getPagination() {
		return pagination;
	}

	public void setPagination(ListPagingDto pagination) {
		this.pagination = pagination;
	}

	/**
	 * @param departmentDto the departmentDto to set
	 */
	public void setDepartmentDto(List<DepartmentDto> departmentDto) {
		this.departmentDto = departmentDto;
	}

	/**
	 * @return the idDepart
	 */
	public Long getIdDepart() {
		return idDepart;
	}

	/**
	 * @param idDepart the idDepart to set
	 */
	public void setIdDepart(Long idDepart) {
		this.idDepart = idDepart;
	}

	/**
	 * @return the nameStaff
	 */
	public String getNameStaff() {
		return nameStaff;
	}

	/**
	 * @param nameStaff the nameStaff to set
	 */
	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	/**
	 * @return the pn
	 */
	public Long getPn() {
		return pn;
	}

	/**
	 * @param pn the pn to set
	 */
	public void setPn(Long pn) {
		this.pn = pn;
	}

	public List<EmployeeDto> getListEmp() {
		return listEmp;
	}

	public void setListEmp(List<EmployeeDto> listEmp) {
		this.listEmp = listEmp;
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
	
	

}
