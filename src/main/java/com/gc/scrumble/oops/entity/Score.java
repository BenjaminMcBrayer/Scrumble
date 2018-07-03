package com.gc.scrumble.oops.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
/**
 * @author Ben McBrayer, Brent Coppinger, Victoria Rush
 *
 */
@Entity
@Table(name = "scores")
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scoreid;
	private Long scoreval;
	@JoinColumn(foreignKey = @ForeignKey(name = "userid"))
	private Long userid;
	@JoinColumn(foreignKey = @ForeignKey(name = "wordid"))
	private Long wordid;

	public Score() {
	}

	public Score(Long scoreid, Long scoreval, Long userid, Long wordid) {
		this.scoreid = scoreid;
		this.scoreval = scoreval;
		this.userid = userid;
		this.wordid = wordid;
	}
	
	public Score(Long scoreval, Long userid, Long wordid) {
		this.scoreval = scoreval;
		this.userid = userid;
		this.wordid = wordid;
	}

	public Long getScoreid() {
		return scoreid;
	}

	public void setScoreid(Long scoreid) {
		this.scoreid = scoreid;
	}

	public Long getScoreval() {
		return scoreval;
	}

	public void setScoreval(Long scoreval) {
		this.scoreval = scoreval;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getWordid() {
		return wordid;
	}

	public void setWordid(Long wordid) {
		this.wordid = wordid;
	}

	@Override
	public String toString() {
		return "Score scoreid: " + scoreid + ", scoreval: " + scoreval + ", userid: " + userid + ", wordid: " + wordid;
	}


}
