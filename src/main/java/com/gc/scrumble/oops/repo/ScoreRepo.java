package com.gc.scrumble.oops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gc.scrumble.oops.entity.Score;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Long> {
	
	@Query(value = "select max(s.scoreval) from scores s where s.userid =:userid", nativeQuery = true)			
	public long getMaxscore(@Param("userid") long userid);
	
	public Score findScoreByUserid(Long userid);
	
	public Score findScoreByWordid(Long wordid);
	
	public Score findScoreByUseridAndWordid(Long userid, Long wordid);
	

}
