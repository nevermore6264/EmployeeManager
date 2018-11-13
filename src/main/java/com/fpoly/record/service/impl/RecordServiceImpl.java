package com.fpoly.record.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.common.bases.BaseService;
import com.fpoly.common.dto.ListDataDto;
import com.fpoly.common.dto.ListPagingDto;
import com.fpoly.common.entities.Employee;
import com.fpoly.common.entities.Record;
import com.fpoly.common.utils.DataTransformUtil;
import com.fpoly.record.repositories.EmployeeRepository;
import com.fpoly.record.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.poly.sof305.group1.account.dto.AccountDto;
import vn.poly.sof305.group1.common.bases.BaseService;
import vn.poly.sof305.group1.common.dto.ListDataDto;
import vn.poly.sof305.group1.common.dto.ListPagingDto;
import vn.poly.sof305.group1.common.entities.Account;
import vn.poly.sof305.group1.common.entities.Employee;
import vn.poly.sof305.group1.common.entities.Record;
import vn.poly.sof305.group1.common.utils.DataTransformUtil;
import vn.poly.sof305.group1.record.dto.ReEmployeeDto;
import vn.poly.sof305.group1.record.dto.RecordDto;
import vn.poly.sof305.group1.record.repositories.EmployeeRepository;
import vn.poly.sof305.group1.record.repositories.RecordRepository;
import vn.poly.sof305.group1.record.service.RecordService;

@Service
public class RecordServiceImpl extends BaseService implements RecordService {
	@Autowired
	RecordRepository recordRepository;
	
	@Autowired
	@Qualifier("reEmployeeRepository")
	EmployeeRepository employeeRepository;

	
	@Override
	public List<ReEmployeeDto> employees(String name) {
		List<Employee> employeeList = employeeRepository.search(name);
		List<ReEmployeeDto> employeeDtoList = new ArrayList<>();
		for (Employee employee : employeeList) {
			employeeDtoList.add((ReEmployeeDto) DataTransformUtil.transform(employee, ReEmployeeDto.class));
		}
		return employeeDtoList;
	}
	
	@Override
	public boolean create(RecordDto recordDto) {
		Record record = (Record) DataTransformUtil.transform(recordDto, Record.class);
		recordRepository.create(record);
		return true;
	}
	
	
	@Override
	public RecordDto selectId(Long id) {
		Record record = recordRepository.select(id);
	        if (record == null) {
	            throw new RuntimeException("Cannot find entity with id or It was deleted");
	        }
	        return (RecordDto) DataTransformUtil.transform(record, RecordDto.class);
	}

	@Override
	public boolean update(RecordDto recordDto) {
		Record record = recordRepository.select(recordDto.getId());
		 if (record == null) {
	            throw new RuntimeException("Cannot find entity with id or It was deleted");
	        }
		record.setIdStaff(recordDto.getIdStaff());
		record.setType(recordDto.isType());
		record.setReason(record.getReason());
		record.setDate(recordDto.getDate());
		
		recordRepository.update(record);
		
		 return true;
	}

	@Override
	public boolean remove(Long id) {
		Record record = recordRepository.select(id);
		if (record == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		recordRepository.remove(id);
		return true;
	}


	
	

	@Override
	public ListDataDto<RecordDto> getList(Long idStaff, boolean type, Long pn) {
		ListDataDto<RecordDto> listDataDto = new ListDataDto<RecordDto>();

		// Calculating paging
		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(pn);

		// Count record
		Long totalRecords = recordRepository.count(idStaff, type);
		pagingDto.setTotalRecords(totalRecords);

		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		List<Record> recordList = recordRepository.select(idStaff, type, pagingDto.getOffset(),
				pagingDto.getLimit());

		// cast account dto with lecturer entity
		List<RecordDto> recordDtoList = new ArrayList<>();
		for (Record record : recordList) {

			RecordDto recordDto = (RecordDto) DataTransformUtil.transform(record, RecordDto.class);

			Employee employee = record.getEmployee();
			recordDto.setIdStaff(employee.getId());
			recordDto.setNameStaff(employee.getNameStaff());
			recordDtoList.add(recordDto);
		}
		// Set list into data dto
		listDataDto.setList(recordDtoList);

		// Return data
		return listDataDto;
	}
}
