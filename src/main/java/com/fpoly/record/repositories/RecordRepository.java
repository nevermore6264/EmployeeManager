package com.fpoly.record.repositories;

import java.util.List;

import com.fpoly.common.entities.Record;
import com.fpoly.common.entities.Record;

public interface RecordRepository {

	boolean create(Record record);

	boolean update(Record record);

	Record select(Long id);

	boolean remove(Long id);
	
	List<Record> select(Long idStaff, boolean type, int offset, int limit);
	
	Long count(Long idStaff, boolean type);
	

}
