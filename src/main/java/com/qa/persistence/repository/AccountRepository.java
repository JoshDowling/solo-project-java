package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();

	String addAccount(String account);

	String updateAccount(Long id, String accountToUpdate, String toChange);

	String deleteAccount(Long id);

}