package com.qa.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.ServiceInterface;


@Path("/account")
public class AccountEndpoint {

	@Inject
	private ServiceInterface service;

	@Path("/getAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/addAccounts")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}

	@Path("/updateAccount/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long accountID, String account) {
		return service.updateAccount(accountID, account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long accountID) {
		return service.deleteAccount(accountID);
	}
	
	@Path("/addTeam")
	@POST
	@Produces({ "application/json" })
	public String addTeam(String team) {
		return service.addTeam(team);
	}
	
	
	
	@Path("/addPlayer")
	@POST
	@Produces({ "application/json" })
	public String addPlayer(String player) {
		return service.addPlayer(player);
	}
	
	@Path("/deletePlayer/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deletePlayer(@PathParam("id") Long id) {
		return service.deletePlayer(id);
	}

	public void setService(ServiceInterface service) {
		this.service = service;
	}

}
