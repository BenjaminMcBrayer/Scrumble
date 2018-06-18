package com.gc.scrumble.oops.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

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

	public Score(Long scoreid, Long scoreval) {
		this.scoreid = scoreid;
		this.scoreval = scoreval;
	}

	public Score(Long scoreval) {
		this.scoreval = scoreval;
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

	@Override
	public String toString() {
		return "Score [scoreid=" + scoreid + ", scoreval=" + scoreval + "]";
	}
}
