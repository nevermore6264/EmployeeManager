package com.fpoly.account.repositories;

import java.util.List;

import com.fpoly.common.bases.BaseRepositoryInterface;
import com.fpoly.common.entities.Account;
import com.fpoly.common.bases.BaseRepositoryInterface;
import com.fpoly.common.entities.Account;

public interface AccountRepository extends BaseRepositoryInterface {

	List<Account> listAccount();

	Account findOne(Long id);

	boolean checkAuth(String userName, String password);

	boolean deleteAccount(Long id);

	boolean add(Account acount);

	boolean update(Account account);

	boolean checkUsers(String userName);

	Long count(String username);

	List<Account> select(String username, int offset, int limit);
}
