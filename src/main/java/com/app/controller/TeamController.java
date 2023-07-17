package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TeamDTO;
import com.app.service.ITeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	ITeamService teamService;
	
	@PostMapping
	ResponseEntity<?> addTeam(@RequestBody TeamDTO teamDTO) {
	  return	ResponseEntity.status(HttpStatus.OK).body(teamService.addTeam(teamDTO));
	}
}
