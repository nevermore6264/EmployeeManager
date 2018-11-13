package com.fpoly.employee.service;

import java.util.List;

import com.fpoly.common.dto.ListDataDto;
import com.fpoly.employee.dto.DepartmentDto;
import com.fpoly.employee.dto.EmployeeDto;
import vn.poly.sof305.group1.common.dto.ListDataDto;
import vn.poly.sof305.group1.employee.dto.DepartmentDto;
import vn.poly.sof305.group1.employee.dto.EmployeeDto;

public interface EmployeeService {
		
		ListDataDto<EmployeeDto> listEmp(Long idDepart, String nameStaff, Long pn);
		
		List<DepartmentDto> departmentDtos(String code);
		
		boolean create(EmployeeDto employeeDto);
		
		boolean update(EmployeeDto employeeDto);
		
		boolean remove(Long id);
		
		EmployeeDto detail(Long id);
		
		boolean check(String code);
}
