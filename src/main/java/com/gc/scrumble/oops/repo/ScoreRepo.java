package com.gc.scrumble.oops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.scrumble.oops.entity.Score;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Long> {
	
	public Score findScoreByUserid(Long userid);
	
	public Score findScoreByWordid(Long wordid);
	
	public Score findScoreByUseridAndWordid(Long userid, Long wordid);
	

}
