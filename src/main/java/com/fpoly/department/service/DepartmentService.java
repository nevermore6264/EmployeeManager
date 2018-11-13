package com.fpoly.department.service;

import java.util.List;

import vn.poly.sof305.group1.common.bases.BaseServiceInterface;
import vn.poly.sof305.group1.department.dto.DepartmentDto;

public interface DepartmentService extends BaseServiceInterface {
	/*ListDataDto<DepartmentDto> getListDepart(String code, String name, Long pn);*/

	List<DepartmentDto> list();

	boolean create(DepartmentDto departmentDto);

	boolean update(DepartmentDto departmentDto);

	boolean remove(Long id);

	DepartmentDto selectId(Long id);
	
	boolean check(String code);
}
