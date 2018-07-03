package com.gc.scrumble.oops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gc.scrumble.oops.entity.Score;
/**
 * @author Ben McBrayer, Brent Coppinger, Victoria Rush
 *
 */
@Repository
public interface ScoreRepo extends JpaRepository<Score, Long> {
	
	@Query(value = "select max(s.scoreval) from scores s where s.userid =:userid", nativeQuery = true)			
	public long getMaxscore(@Param("userid") long userid);

	@Query(value = "select max(s.scoreval) from scores s where s.userid =:userid and wordid=:wordid", nativeQuery = true)			
	public long getMaxwordscore(@Param("userid") long userid, @Param("wordid") long wordid);

	@Query(value = "select avg(s.scoreval) from scores s where wordid=:wordid", nativeQuery = true)			
	public long getAvgwordscore(@Param("wordid") long wordid);

	public Score findScoreByUserid(Long userid);
	
	public Score findScoreByWordid(Long wordid);
	
	public Score findScoreByUseridAndWordid(Long userid, Long wordid);
	

}
