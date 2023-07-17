package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.TeamDTO;


public interface ITeamService {

	String addTeam(TeamDTO teamDTO);
}
