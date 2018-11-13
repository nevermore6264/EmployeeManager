package com.fpoly.employee.repositories;

import java.util.List;

import com.fpoly.common.entities.Department;
import vn.poly.sof305.group1.common.entities.Department;

public interface DepartmentRepository  {
	
	List<Department> select(String code);
}
