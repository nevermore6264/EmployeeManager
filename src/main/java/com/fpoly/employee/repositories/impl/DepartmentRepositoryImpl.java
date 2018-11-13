package com.fpoly.employee.repositories.impl;

import java.util.List;

import com.fpoly.common.bases.BaseRepository;
import com.fpoly.common.entities.Department;
import com.fpoly.employee.repositories.DepartmentRepository;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.common.bases.BaseRepository;
import com.fpoly.common.entities.Department;
import com.fpoly.employee.repositories.DepartmentRepository;

@Repository("emDepartRepositoryImpl")
public class DepartmentRepositoryImpl extends BaseRepository implements DepartmentRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Department> select(String code) {
		
		 StringBuilder queryStb = new StringBuilder("from Department ");

	        // TODO

	        // Add order conditional
	        queryStb.append(" order by code");

	        // Build query
	        Query query = this.getCurrentSession().createQuery(queryStb.toString());

	     
	        return query.list();
	}
}
