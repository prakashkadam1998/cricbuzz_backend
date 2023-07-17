package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.app.entity.Series;

@Repository
public interface ISeriesDao extends JpaRepository <Series, Long> {

    //	@Query("select s from Series s where s.name=:nm")   
	Series findByName(@Param("nm")String name);
}
