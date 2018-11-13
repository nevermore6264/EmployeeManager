package com.fpoly.statics.repositories.impl;

import java.util.List;

import com.fpoly.common.bases.BaseRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.common.bases.BaseRepository;
import com.fpoly.statics.repositories.StaticRepository;

@Repository
public class StaticRepositoryImpl extends BaseRepository implements StaticRepository{


	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listStatics() {
		List<Object[]> list = this.getCurrentSession().createQuery("SELECT r.employee.code, r.employee.nameStaff,r.employee.photo," 
				+ " SUM(case when r.type=1 then 1 else 0 end), "
				+ " SUM(case when r.type=0 then 1 else 0 end) " + " FROM Record r " + " GROUP BY r.employee.code").list();
		
		return list;
	}
	

	}
