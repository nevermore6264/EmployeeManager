package com.fpoly.employee.repositories.impl;

import java.util.List;

import com.fpoly.common.bases.BaseRepository;
import com.fpoly.common.entities.Employee;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import vn.poly.sof305.group1.common.bases.BaseRepository;
import vn.poly.sof305.group1.common.entities.Employee;
import vn.poly.sof305.group1.employee.repositories.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl extends BaseRepository implements EmployeeRepository{
	
	
	@Override
	public Long count(Long idDepart, String nameStaff) {
		// Build query string with default conditional
				StringBuilder queryStb = new StringBuilder("select count(1) from Employee");

				// Add lecturerId && name condition
				if (StringUtils.isNoneBlank(nameStaff) && idDepart != null) {
					queryStb.append(" where nameStaff like :nameStaff and idDepart = :idDepart");

				// Add lecturerId condition
				} else if (idDepart != null) {
					queryStb.append(" where idDepart = :idDepart ");
				}

				// Add name condition
				else if (StringUtils.isNotBlank(nameStaff)) {
					queryStb.append(" where nameStaff like :nameStaff ");
				}

				// Build query
				Query query = this.getCurrentSession().createQuery(queryStb.toString());

				// Set lecturerId parameter
				if (idDepart != null) {
					query.setLong("idDepart", idDepart);
				}

				// Set name parameter
				if (StringUtils.isNotBlank(nameStaff)) {
					query.setString("nameStaff", "%" + nameStaff + "%");
				}

				return (Long) query.uniqueResult();
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> select(Long idDepart, String nameStaff, int offset, int limit) {
		// Build query string with default conditional
				StringBuilder queryStb = new StringBuilder("from Employee ");

				// Add lecturerId && name condition
				if (StringUtils.isNoneBlank(nameStaff) && idDepart != null) {
					queryStb.append(" where nameStaff like :nameStaff and idDepart = :idDepart");
				}

				// Add lecturerId condition
				else if (idDepart != null) {
					queryStb.append(" where idDepart = :idDepart ");
				}

				// Add name condition
				else if (StringUtils.isNotBlank(nameStaff)) {
					queryStb.append(" where nameStaff like :nameStaff ");
				}
				
				// Add order conditional
				queryStb.append(" order by nameStaff");

				// Build query
				Query query = this.getCurrentSession().createQuery(queryStb.toString());

				// Set lecturerId parameter
				if (idDepart != null) {
					query.setLong("idDepart", idDepart);
				}

				// Set name parameter
				if (StringUtils.isNotBlank(nameStaff)) {
					query.setString("nameStaff", "%" + nameStaff + "%");
				}

				return query.setFirstResult(offset).setMaxResults(limit).list();
	}	

	@Override
	public boolean insert(Employee employee) {
		 super.insert(employee);
		return true;
	}

	@Override
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Employee employees = session.get(Employee.class, id);
		session.delete(employees);
		return true;
	}

	@Override
	public Employee select(Long id) {
		Employee entity = this.getCurrentSession().get(Employee.class, id);

		return entity;
	}

	@Override
	public boolean update(Employee employee) {
		super.update(employee);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean check (String code) {
		String sql = "FROM Employee WHERE code = '" + code + "'";
		List<Employee> list = this.getCurrentSession().createQuery(sql).list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	
}
