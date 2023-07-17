package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Series;
import com.app.entity.SeriesStats;
import com.app.entity.Team;

public interface ISeriesStatsDao extends JpaRepository<SeriesStats, Long>{
	
	
	// Actually through series_id cuz providing ref here
	@Query("select s from SeriesStats s where s.startDate =:startD and s.series=:series")
	List<SeriesStats> findByIdAndDate(@Param("startD") LocalDate startDate,@Param("series")Series series);

	 List<SeriesStats> findByStartDate(LocalDate startDate);
	 
	 @Query("select s from SeriesStats s where s.startDate =:startD and s.series=:series and s.team=:team")
	 SeriesStats findBySeriesTeamStartDate(@Param("startD")LocalDate startDate,@Param("series")Series series,
			 @Param("team")Team team);
}