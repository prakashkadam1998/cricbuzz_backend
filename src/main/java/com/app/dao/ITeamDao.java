package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Team;

@Repository
public interface ITeamDao extends JpaRepository<Team, Long> {

	@Query("select t from Team t where t.shortName = :tName")
	Team findByShortName(@Param("tName")String  teamName);
}
