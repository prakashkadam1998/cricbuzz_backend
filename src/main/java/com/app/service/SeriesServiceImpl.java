package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProfileDao;
import com.app.dao.ISeriesDao;
import com.app.dao.ISeriesStatsDao;
import com.app.dao.ITeamDao;
import com.app.dto.ProfileDTO;
import com.app.dto.SeriesDTO;
import com.app.dto.SeriesStatsDTO;
import com.app.entity.Profile;
import com.app.entity.Series;
import com.app.entity.SeriesStats;
import com.app.entity.Team;

@Service
@Transactional
public class SeriesServiceImpl implements ISeriesService{
	@Autowired
	ISeriesDao seriesDao;
	
	@Autowired
	ISeriesStatsDao seriesStatsDao;
	
	@Autowired
	ITeamDao teamDao;
	
	@Autowired
	IProfileDao profileDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public String addSeries(SeriesDTO seriesDTO) {
		Series series=  mapper.map(seriesDTO,Series.class);
		seriesDao.save(series);
		return "Details added succesfully";
	}

	@Override
	public SeriesDTO getSeriesDetails(String seriesName) {
		Series series= seriesDao.findByName(seriesName);
		return mapper.map(series,SeriesDTO.class);
	}

	

	@Override
	public String addSeriesStats(SeriesStatsDTO seriesStats,String seriesName,String teamName) {
		Series series = seriesDao.findByName( seriesName);
		Team team = teamDao.findByShortName(teamName);
		 SeriesStats statsEntity= mapper.map(seriesStats,SeriesStats.class);
		 statsEntity.setSeries(series);
		 statsEntity.setTeam(team);
		 System.out.println(statsEntity.getGroupName());
		seriesStatsDao.save(statsEntity);
		return "Stats Added";   
		// can returned entity as well by mapping to SeriesStatsDTO
	}
	
	@Override
	public List<SeriesStatsDTO> getSeriesStatsByDate(LocalDate startDate, String seriesName) {
			Series series = seriesDao.findByName( seriesName);
			System.out.println(series.getId());
			System.out.println(startDate);
			return seriesStatsDao.findByIdAndDate(startDate,series).stream().map(stats ->mapper.map(stats,SeriesStatsDTO.class)).collect(Collectors.toList());
	//	return mapper.map(seriesStats,SeriesStatsDTO.class);
	}

	@Override
	public String addSquadProfiles(LocalDate startDate,String seriesName, String teamName, Long id) {
		Series series = seriesDao.findByName( seriesName);
		Team team = teamDao.findByShortName(teamName);
//		List<SeriesStats> seriesStats=  seriesStatsDao.findByStartDate(startDate);
//		System.out.println(seriesStats);
		
		SeriesStats seriesStats=  seriesStatsDao.findBySeriesTeamStartDate(startDate,series,team);
		Profile profile=  profileDao.findById(id).orElseThrow(()->new RuntimeException("profile Not found"));
		System.out.println(startDate+" "+seriesName+" "+teamName+" "+id);
		seriesStats.getProfiles().add(profile);
		return "player added to squad";
	}

	@Override
	public List<ProfileDTO> getSquad(LocalDate startDate,String seriesName, String teamName) {
		
		Series series = seriesDao.findByName(seriesName);
		Team team = teamDao.findByShortName(teamName);
		SeriesStats seriesStats=  seriesStatsDao.findBySeriesTeamStartDate(startDate,series,team);
		return seriesStats.getProfiles().stream().map(profile->mapper.map(profile,ProfileDTO.class)).collect(Collectors.toList());
		
	}
	
	
	

		
}
