package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ProfileDTO;
import com.app.dto.SeriesDTO;
import com.app.dto.SeriesStatsDTO;
import com.app.entity.Profile;

public interface ISeriesService {

	String addSeries(SeriesDTO series);
	SeriesDTO getSeriesDetails(String seriesName);
	
	
	String addSeriesStats(SeriesStatsDTO seriesStats, String seriesName,String teamName);
	List<SeriesStatsDTO> getSeriesStatsByDate(LocalDate startDate,String SeriesName);
	
	String addSquadProfiles(LocalDate startDate,String seriesName, String teamName,Long id);
	List<ProfileDTO> getSquad(LocalDate startDate,String seriesName, String teamName);
}
