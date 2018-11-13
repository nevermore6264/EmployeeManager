package com.fpoly.record.repositories.impl;

import java.util.List;

import com.fpoly.common.bases.BaseRepository;
import com.fpoly.common.entities.Record;
import com.fpoly.record.repositories.RecordRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import vn.poly.sof305.group1.common.bases.BaseRepository;
import vn.poly.sof305.group1.common.entities.Record;
import vn.poly.sof305.group1.record.repositories.RecordRepository;
@Repository
public class RecordRepositoryImpl extends BaseRepository implements RecordRepository {

	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Record> select(Long idStaff, boolean type, int offset, int limit) {

		StringBuilder queryStb = new StringBuilder("from Record");


		if (idStaff != null && type ) {
			queryStb.append(" where idStaff = :idStaff and type = :type");
		} 
		else if (idStaff != null) {
			queryStb.append(" where idStaff = :idStaff");
		} else if (type) {
			queryStb.append(" where type = :type");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (idStaff != null) {
            query.setLong("idStaff", idStaff);
        }
		if (type) {
			query.setBoolean("type", type);
		}

		return query.setFirstResult(offset).setMaxResults(limit).list();
	}
	
	
	@Override
	public Long count(Long idStaff, boolean type) {
		StringBuilder queryStb = new StringBuilder("select count(1) from Record");
		
		if (idStaff != null && type) {
			queryStb.append(" where idStaff = :idStaff and type = :type");
		} else if (idStaff != null) {
			queryStb.append(" where idStaff = :idStaff");
		} else if (type) {
			queryStb.append(" where type = :type");
		}
		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (idStaff != null) {
			query.setLong("idStaff", idStaff);
		}
		if (type) {
			query.setBoolean("type",type);
		}
		return (Long) query.uniqueResult();
	}
	
	
	public boolean create(Record record) {
		super.insert(record);
		return true;
	}
	
	public Record select(Long id) {
		Record record =  this.getCurrentSession().get(Record.class, id);
		return record;
	}
	
	public boolean update(Record record) {
		super.update(record);
		return true;
	}
	

	
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Record record = session.get(Record.class, id);
		session.delete(record);
		return true;
	}


}
