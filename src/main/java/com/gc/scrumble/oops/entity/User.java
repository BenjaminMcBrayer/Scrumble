package com.gc.scrumble.oops.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String username;
	private String pword;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "scores", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "wordid"))
	private List <Score> scores;

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
	
	public User(User user) {
		this.userid = user.getUserid();
		this.username = user.getUsername();
		this.pword = user.getPword();
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

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", pword=" + pword + ", scores=" + scores + "]";
	}

}
