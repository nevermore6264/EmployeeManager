package com.fpoly.statics.service.impl;

import java.util.List;

import com.fpoly.common.bases.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.poly.sof305.group1.common.bases.BaseService;
import vn.poly.sof305.group1.statics.repositories.StaticRepository;
import vn.poly.sof305.group1.statics.service.StaticService;

@Service
public class StaticServiceImpl extends BaseService implements StaticService {
@Autowired
StaticRepository staticRepository;
	
	@Override
	public List<Object[]> listStatics() {
	return  staticRepository.listStatics();
	
	}

	

}
