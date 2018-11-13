package com.fpoly.employee.repositories;

import java.util.List;

import com.fpoly.common.entities.Department;
import com.fpoly.common.entities.Department;

public interface DepartmentRepository  {
	
	List<Department> select(String code);
}
