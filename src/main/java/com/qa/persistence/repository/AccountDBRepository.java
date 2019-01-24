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
import com.qa.persistence.domain.Player;
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
	public String updateAccount(Long accountID, String account) {
		Account theAccount = findAccount(accountID);
		manager.remove(theAccount);
		Account anAccount = util.getObjectForJSON(account,  Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has ben successfully updated\"}";
	}


	@Transactional(REQUIRED)
	public String deleteAccount(Long accountID) {
		Account accountFromDB = findAccount(accountID);
		if(accountFromDB != null) {
			manager.remove(accountFromDB);
		}
		return "{\"message\": \"account has been successfully deleted\"}";
	}
	
	public String addPlayer(String player) {
		Player aPlayer = util.getObjectForJSON(player, Player.class);
		manager.persist(aPlayer);
		return "{\"message\": \"Player has been successfully added\"}";
	}
	
	public String deletePlayer(Long id) {
		Player playerFromDB = findPlayer(id);
		if(playerFromDB != null) {
			manager.remove(playerFromDB);
		}
		return "{\"message\": \"Player has been successfully deleted\"}";
	}
	
	
	public Account findAccount(Long accountID) {
		return manager.find(Account.class, accountID);
		}
	
	public Player findPlayer(Long id) {
		return manager.find(Player.class, id);
		}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	

}
