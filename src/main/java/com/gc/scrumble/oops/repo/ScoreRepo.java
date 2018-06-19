package com.gc.scrumble.oops.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gc.scrumble.oops.entity.Score;

public interface ScoreRepo extends JpaRepository<Score, Integer> {
	
	public Score findScoreByUserid(long userid);
	
	public Score findScoreByWordid(long wordid);
	
	public Score findScoreByUseridAndWordid(long userid, long wordid);
	

}
