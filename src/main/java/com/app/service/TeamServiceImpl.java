package com.app.service;



import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ITeamDao;
import com.app.dto.TeamDTO;
import com.app.entity.Team;

@Transactional
@Service
public class TeamServiceImpl implements ITeamService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ITeamDao teamDao;
	
	@Override
	public String addTeam(TeamDTO teamDTO) {
		 Team team = mapper.map(teamDTO,Team.class);
		 teamDao.save(team);
		return "Team Added";
	}

	
}
