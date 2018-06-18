package com.gc.scrumble.oops.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String username;
	private String pword;

	public User() {
	}

	public User(Long userid, String username, String pword) {
		this.userid = userid;
		this.username = username;
		this.pword = pword;
	}
	
	public User(String username, String pword) {
		this.username = username;
		this.pword = pword;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", pword=" + pword + "]";
	}
}
