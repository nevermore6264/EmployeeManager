package com.fpoly.department.repositories;



import java.util.List;

import vn.poly.sof305.group1.common.bases.BaseRepositoryInterface;
import vn.poly.sof305.group1.common.entities.Department;


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
