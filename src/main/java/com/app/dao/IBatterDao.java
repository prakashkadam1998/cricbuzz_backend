package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Batter;

public interface IBatterDao extends JpaRepository<Batter, Long> {

}
