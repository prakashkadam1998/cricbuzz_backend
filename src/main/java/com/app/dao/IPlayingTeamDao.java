package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.PlayingTeam;

public interface IPlayingTeamDao extends JpaRepository<PlayingTeam, Long>{

}
