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

	@Path("/addAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}

	@Path("/updateAccount/{username}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("username") String username, String account) {
		return service.updateAccount(username, account);
	}

	@Path("/deleteAccount/{username}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("username") String username) {
		return service.deleteAccount(username);
	}
	
	@Path("/addTeam")
	@POST
	@Produces({ "application/json" })
	public String addTeam(String team) {
		return service.addTeam(team);
	}
	
	@Path("/getTeams")
	@GET
	@Produces({ "application/json" })
	public String getAllTeams() {
		return service.getAllTeams();
	}

	@Path("/updateTeam/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTeam(@PathParam("id") Long teamID, String team) {
		return service.updateTeam(teamID, team);
	}

	@Path("/deleteTeam/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTeam(@PathParam("id") Long teamID) {
		return service.deleteTeam(teamID);
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
	
	@Path("/login")
	@POST
	@Produces({ "application/json" })
	public String login(String account) {
		return service.login(account);
	}

	public void setService(ServiceInterface service) {
		this.service = service;
	}

}
