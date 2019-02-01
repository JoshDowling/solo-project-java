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

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Team;
import com.qa.service.ServiceImpl;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	
	private static final Logger LOGGER = Logger.getLogger(AccountDBRepository.class);
	
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
	
	public String getAllTeams() {
		Query query = manager.createQuery("Select a From Team a");
		Collection<Team> resultTeam = (Collection<Team>)query.getResultList();
		return util.getJSONForObject(resultTeam);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String addTeam(String team) {
		Team aTeam = util.getObjectForJSON(team, Team.class);
		manager.persist(aTeam);
		return "{\"message\": \"A team has been successfully added\"}";
	}
	@Override
	@Transactional(REQUIRED)
	public String updateTeam(Long teamID, String team) {
		Team teamFromDB = findTeam(teamID);
		if(teamFromDB != null) {
			manager.remove(teamFromDB);
			Team aTeam = util.getObjectForJSON(team, Team.class);
			manager.persist(aTeam);
			return "{\"message\": \"Team has been successfully updated\"}";
		}
		return "{\"message\": \"Team has been not successfully updated\"}";
	}
	
	
	@Transactional(REQUIRED)
	public String deleteTeam(Long teamID) {
		Team teamFromDB = findTeam(teamID);
		if(teamFromDB != null) {
			manager.remove(teamFromDB);
		}
		return "{\"message\": \"Team has been successfully deleted\"}";
	}
	
	
	@Transactional(REQUIRED)
	public String addPlayer(String player) {
		Player aPlayer = util.getObjectForJSON(player, Player.class);
		manager.persist(aPlayer);
		return "{\"message\": \"Player has been successfully added\"}";
	}
	@Transactional(REQUIRED)
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
	
	public Team findTeam(Long teamID) {
		return manager.find(Team.class, teamID);
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
