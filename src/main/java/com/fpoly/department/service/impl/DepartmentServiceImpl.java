package com.fpoly.department.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.department.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fpoly.common.bases.BaseService;
import com.fpoly.common.entities.Department;
import com.fpoly.common.utils.DataTransformUtil;
import com.fpoly.department.dto.DepartmentDto;
import com.fpoly.department.repositories.DepartmentRepository;
import com.fpoly.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends BaseService implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	@Override
	public List<DepartmentDto> list() {
		
		
		List<Department> listDepart = departmentRepository.listDepartment();
		List<DepartmentDto> listDepartDto = new ArrayList<>();
		for (Department depart : listDepart) {
			listDepartDto.add((DepartmentDto) DataTransformUtil.transform(depart, DepartmentDto.class));
		}
		return listDepartDto;
	}

	@Override
	public boolean create(DepartmentDto departmentDto) {
		Department department = (Department) DataTransformUtil.transform(departmentDto, Department.class);
		 departmentRepository.create(department);
		return true;
	}
	
	
	
	@Override
	public boolean update(DepartmentDto departmentDto) {
		Department depart = departmentRepository.select(departmentDto.getId());
		if (depart == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		depart.setCode(departmentDto.getCode());
		depart.setNameDepart(departmentDto.getNameDepart());
		
		departmentRepository.update(depart);
		 return true;
	}
	
	@Override
	public DepartmentDto selectId(Long id) {
		Department department = departmentRepository.select(id);
	        if (department == null) {
	            throw new RuntimeException("Cannot find entity with id or It was deleted");
	        }
	        return (DepartmentDto) DataTransformUtil.transform(department, DepartmentDto.class);
	}
	
	@Override
	public boolean remove(Long id) {
		Department department = departmentRepository.select(id);
		if (department == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		departmentRepository.remove(id);
		return true;
	}

	@Override
	public boolean check(String code) {
		return departmentRepository.check(code);
	}


	
	
}
