package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.ProfileStats;

public interface IProfileStatsDao extends JpaRepository<ProfileStats, Long>{

}
