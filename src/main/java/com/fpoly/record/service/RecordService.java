package com.fpoly.record.service;

import java.util.List;

import com.fpoly.common.dto.ListDataDto;
import vn.poly.sof305.group1.common.dto.ListDataDto;
import vn.poly.sof305.group1.record.dto.ReEmployeeDto;
import vn.poly.sof305.group1.record.dto.RecordDto;

public interface RecordService {
	List<ReEmployeeDto> employees(String name);
	boolean create(RecordDto recordDto);
	boolean update(RecordDto recordDto);
	RecordDto selectId(Long id);
	boolean remove(Long id);

	ListDataDto<RecordDto> getList(Long idStaff, boolean type, Long pn);


}
