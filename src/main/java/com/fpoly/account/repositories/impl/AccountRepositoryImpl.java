package com.fpoly.account.repositories.impl;

import java.util.List;

import com.fpoly.common.bases.BaseRepository;
import com.fpoly.common.entities.Account;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.account.repositories.AccountRepository;
import com.fpoly.common.bases.BaseRepository;
import com.fpoly.common.entities.Account;

@Repository
public class AccountRepositoryImpl extends BaseRepository implements AccountRepository {

	@SuppressWarnings("unchecked")
	public List<Account> listAccount() {
		List<Account> listAccount = this.getCurrentSession().createQuery("from Account").list();
		return listAccount;
	}

	@Override
	public Account findOne(Long id) {
		Account account = this.getCurrentSession().get(Account.class, id);
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkAuth(String userName, String password) {
		String sql = "FROM Account WHERE username = '" + userName + "' AND password = '" + password + "'";
		List<Account> list = this.getCurrentSession().createQuery(sql).list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAccount(Long id) {
		super.deleteUser(id);
		return true;
	}

	@Override
	public boolean add(Account acount) {
		super.insert(acount);
		return true;
	}

	@Override
	public boolean update(Account account) {
		super.update2(account);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkUsers(String userName) {
		String sql = "FROM Account WHERE username = '" + userName + "'";
		List<Account> list = this.getCurrentSession().createQuery(sql).list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Long count(String username) {
		StringBuilder queryStb = new StringBuilder("select count(1) from Account");

		if (StringUtils.isNoneBlank(username)) {
			queryStb.append(" where username like :username");
		} else if (StringUtils.isNotBlank(username)) {
			queryStb.append(" where username like :username ");
		}
		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (StringUtils.isNotBlank(username)) {
			query.setString("username", "%" + username + "%");
		}
		return (Long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> select(String username, int offset, int limit) {
		StringBuilder queryStb = new StringBuilder("from Account ");

		if (StringUtils.isNoneBlank(username)) {
			queryStb.append(" where username like :username ");
		} else if (StringUtils.isNotBlank(username)) {
			queryStb.append(" where username like :username ");
		}
		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (StringUtils.isNotBlank(username)) {
			query.setString("username", "%" + username + "%");
		}
		return query.setFirstResult(offset).setMaxResults(limit).list();
	}

}
