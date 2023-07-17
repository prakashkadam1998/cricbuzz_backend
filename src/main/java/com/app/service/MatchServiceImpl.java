package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IMatchDao;
import com.app.dao.IPlayingTeamDao;
import com.app.dao.IProfileDao;
import com.app.dao.ISeriesDao;
import com.app.dao.ITeamDao;
import com.app.dto.MatchDTO;
import com.app.entity.Match;
import com.app.entity.PlayingTeam;
import com.app.entity.Profile;
import com.app.entity.Series;
import com.app.entity.Team;

@Service
@Transactional
public class MatchServiceImpl implements IMatchService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	IMatchDao matchDao;

	@Autowired
	ISeriesDao seriesDao;
	
	@Autowired
	IProfileDao profileDao;
	@Autowired 
	ITeamDao teamDao;
	@Autowired
	IPlayingTeamDao playingTeamDao;
	
	@Override
	public String addMatch(MatchDTO matchDTO,String seriesName) {
	Match match = mapper.map(matchDTO,Match.class);
	Series series =seriesDao.findByName(seriesName);
	match.setSeries(series);
	matchDao.save(match);
		return "Match Added Successfully";
	}

	@Override
	public String addPlaying11(List<String> names) {
	
	Match match = 	matchDao.findById((long) 1).orElseThrow(()->new RuntimeException("profile Not found"));
	PlayingTeam pTeam = new PlayingTeam();
	Team team = teamDao.findByShortName("GT");
//	Profile profile = profileDao.findByFirstName(names.get(0));
//	pTeam.getPlaying11().add(profile);

	names.forEach(name->pTeam.getPlaying11().add(profileDao.findByFirstName(name)));
	
	pTeam.setTeam(team);
	match.getPlayingTeams().add(pTeam);
	playingTeamDao.save(pTeam);
	return "P11 Added";
	}

	@Override
	public List<Profile> getPlaying11() {
		PlayingTeam playingTeam = playingTeamDao.findById((long)1).orElseThrow(()->new RuntimeException("Playing Team NOt found"));
 // System.out.println(	playingTeam.getPlaying11());
		return playingTeam.getPlaying11();
	}
	
	

}
