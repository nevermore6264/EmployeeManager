package com.fpoly.employee.repositories;

import java.util.List;

import com.fpoly.common.entities.Employee;
import vn.poly.sof305.group1.common.entities.Employee;

public interface EmployeeRepository {
	
	Long count(Long idDepart, String nameStaff);
	 
	List<Employee> select(Long idDepart, String nameStaff, int offset, int limit);
	
	boolean insert(Employee employee);
	
	boolean update(Employee employee);
	
	Employee select(Long id);
	
	boolean remove(Long id);
	
	boolean check(String code);
}
