package com.fpoly.common.bases;

import com.fpoly.common.entities.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fpoly.common.entities.Account;

public class BaseRepository implements BaseRepositoryInterface {

	/*
	 * =============================================================================
	 * =================================== ===== CONSTANT =====
	 * =============================================================================
	 * ===================================
	 */

	/*
	 * =============================================================================
	 * =================================== ===== PROTECTED PROPERTIES =====
	 * =============================================================================
	 * ===================================
	 */

	/** Logger */
	protected final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Protected Resource: JPA Entity Manager
	 */
	@Autowired
	protected SessionFactory sessionFactory;

	/*
	 * =============================================================================
	 * =================================== ===== PROTECTED METHOD =====
	 * =============================================================================
	 * ===================================
	 */

	/**
	 * UnWrap Hibernate session
	 *
	 * @return Current hibernate session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * insert new entity
	 * 
	 * @param entity
	 * 
	 * @return Inserted entity
	 */
	protected Object insert(Object entity) {
		return this.getCurrentSession().save(entity);
	}

	/**
	 * insert new entity
	 * 
	 * @param entity
	 * 
	 * @return Inserted entity
	 */
	protected Object update(Object entity) {
		return this.getCurrentSession().save(entity);
	}

	protected boolean update2(Object entity) {
		this.getCurrentSession().update(entity);
		return true;
	}

	protected boolean deleteUser(Long entity) {
		Session session = this.getCurrentSession();
		Account acc = session.get(Account.class, entity);
		session.delete(acc);
		return true;
	}

}
