package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Match;

public interface IMatchDao extends JpaRepository<Match, Long>{

}
