package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	
	//tells manager to look into the persistence.xml to use the persistence unit called primary
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		Query query = manager.createQuery("Select a From Account a");
		Collection<Account> result = (Collection<Account>)query.getResultList();
		return util.getJSONForObject(result);
	}

	@Transactional(REQUIRED)
	public String addAccount(String account) {
		
		Account anAccount = util.getObjectForJSON(account, Account.class);
		
		manager.persist(anAccount);
		return "{\"message\": \"account has been successfully added\"}";
	}
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String accountToUpdate, String toChange) {
		Account updatedAccount = util.getObjectForJSON(accountToUpdate, Account.class);
		Account accountFromDB = findAccount(id);
		if (accountToUpdate != null) {
			accountFromDB = updatedAccount;
			manager.merge(accountToUpdate);
		}
		return "{\"message\": \"account has ben successfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountFromDB = findAccount(id);
		if(accountFromDB != null) {
			manager.remove(accountFromDB);
		}
		return "{\"message\": \"account has been successfully deleted\"}";
	}
	
	public Account findAccount(Long id) {
		return manager.find(Account.class, id);
		}
	

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
