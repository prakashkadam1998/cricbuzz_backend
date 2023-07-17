package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Inning;

public interface IInnningDao extends JpaRepository<Inning, Long>{

}
