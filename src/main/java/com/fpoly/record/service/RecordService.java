package com.fpoly.record.service;

import java.util.List;

import com.fpoly.common.dto.ListDataDto;
import com.fpoly.common.dto.ListDataDto;
import com.fpoly.record.dto.ReEmployeeDto;
import com.fpoly.record.dto.RecordDto;

public interface RecordService {
	List<ReEmployeeDto> employees(String name);
	boolean create(RecordDto recordDto);
	boolean update(RecordDto recordDto);
	RecordDto selectId(Long id);
	boolean remove(Long id);

	ListDataDto<RecordDto> getList(Long idStaff, boolean type, Long pn);


}
