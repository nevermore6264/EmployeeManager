package com.fpoly.record.repositories;

import java.util.List;

import com.fpoly.common.entities.Employee;
import vn.poly.sof305.group1.common.entities.Employee;

public interface EmployeeRepository {
	List<Employee> search(String name);
}
