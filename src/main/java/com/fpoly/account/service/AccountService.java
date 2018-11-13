package com.fpoly.account.service;

import java.util.List;

import com.fpoly.common.bases.BaseServiceInterface;
import com.fpoly.common.dto.ListDataDto;
import com.fpoly.account.dto.AccountDto;
import com.fpoly.common.bases.BaseServiceInterface;
import com.fpoly.common.dto.ListDataDto;

public interface AccountService extends BaseServiceInterface {

	public List<AccountDto> list();

	AccountDto findOne(Long id);

	public boolean checkAuth(String userName, String password);

	boolean deleteAccount(Long id);

	boolean add(AccountDto accountDto);

	boolean update(AccountDto accountDto);
	
	boolean checkUsers(String userName);
	
	ListDataDto<AccountDto> list(String username, Long page);
}
