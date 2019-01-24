package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long playerID;
	private String firstName;
	private String lastName;
	private int age;
	private String position;
	private long teamID;
	
	
		public Player() {
		}

		public Player(long id, String firstName, String lastName, int age, String position, long accountID) {
			super();
			this.playerID = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.position = position;
			this.teamID = accountID;
		
		}
		
		
		public long getAccountID() {
		return teamID;
	}

		public void setAccountID(long accountID) {
		this.teamID = accountID;
	}
		public long getId() {
			return playerID;
		}

		public void setId(long id) {
			this.playerID = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

}
