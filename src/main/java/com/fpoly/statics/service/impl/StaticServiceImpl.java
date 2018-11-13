package com.fpoly.statics.service.impl;

import java.util.List;

import com.fpoly.common.bases.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.common.bases.BaseService;
import com.fpoly.statics.repositories.StaticRepository;
import com.fpoly.statics.service.StaticService;

@Service
public class StaticServiceImpl extends BaseService implements StaticService {
@Autowired
StaticRepository staticRepository;
	
	@Override
	public List<Object[]> listStatics() {
	return  staticRepository.listStatics();
	
	}

	

}
