package com.fpoly.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.account.repositories.AccountRepository;
import com.fpoly.common.bases.BaseService;
import com.fpoly.common.dto.ListDataDto;
import com.fpoly.common.dto.ListPagingDto;
import com.fpoly.common.entities.Account;
import com.fpoly.common.utils.DataTransformUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.account.dto.AccountDto;
import com.fpoly.account.repositories.AccountRepository;
import com.fpoly.account.service.AccountService;
import com.fpoly.common.bases.BaseService;
import com.fpoly.common.dto.ListDataDto;
import com.fpoly.common.dto.ListPagingDto;
import com.fpoly.common.entities.Account;
import com.fpoly.common.utils.DataTransformUtil;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<AccountDto> list() {

		List<Account> listAcc = accountRepository.listAccount();
		List<AccountDto> listAccDto = new ArrayList<>();
		for (Account account : listAcc) {
			listAccDto.add((AccountDto) DataTransformUtil.transform(account, AccountDto.class));
		}
		return listAccDto;
	}

	@Override
	public AccountDto findOne(Long id) {
		Account account = accountRepository.findOne(id);
		if (account == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}

		return (AccountDto) DataTransformUtil.transform(account, AccountDto.class);

	}

	@Override
	public boolean checkAuth(String userName, String password) {
		return accountRepository.checkAuth(userName, password);
	}

	@Override
	public boolean deleteAccount(Long id) {
		Account acc = accountRepository.findOne(id);
		if (acc == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		accountRepository.deleteAccount(id);
		return true;
	}

	@Override
	public boolean add(AccountDto accountDto) {
		Account acc = (Account) DataTransformUtil.transform(accountDto, Account.class);
		return accountRepository.add(acc);
	}

	@Override
	public boolean update(AccountDto accountDto) {
		Account account = accountRepository.findOne(accountDto.getId());
		if (account == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		account.setId(accountDto.getId());
		account.setUsername(accountDto.getUsername());
		account.setPassword(accountDto.getPassword());
		account.setFullname(accountDto.getFullname());
		return accountRepository.update(account);
	}

	@Override
	public boolean checkUsers(String userName) {
		// TODO Auto-generated method stub
		return accountRepository.checkUsers(userName);
	}

	@Override
	public ListDataDto<AccountDto> list(String username, Long page) {
		// Declare result data
		ListDataDto<AccountDto> listDataDto = new ListDataDto<AccountDto>();

		// Calculating paging
		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(page);

		// Count record
		Long totalRecords = accountRepository.count(username);
		pagingDto.setTotalRecords(totalRecords);

		// Check no result data
		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		// Get list records
		List<Account> accountList = accountRepository.select(username, pagingDto.getOffset(), pagingDto.getLimit());

		// Check record list
		if (CollectionUtils.isEmpty(accountList)) {
			return null;
		}

		// Cast to staffs dto
		List<AccountDto> accountDtoList = new ArrayList<>();
		for (Account student : accountList) {
			accountDtoList.add((AccountDto) DataTransformUtil.transform(student, AccountDto.class));
		}
		listDataDto.setList(accountDtoList);
		return listDataDto;
	}

}
