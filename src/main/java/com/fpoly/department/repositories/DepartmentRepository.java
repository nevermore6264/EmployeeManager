package com.fpoly.department.repositories;



import java.util.List;

import com.fpoly.common.bases.BaseRepositoryInterface;
import com.fpoly.common.entities.Department;


public interface DepartmentRepository extends BaseRepositoryInterface{
	/* Long count(String code, String name);
	 List<Department> select(String code, String name, int offset, int limit);*/
	 List<Department> listDepartment();
	 boolean create(Department department);
	 boolean update(Department department);
	 boolean remove(Long id);
	 Department select(Long id);
	 boolean check(String code);
}
