package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ListDTO;
import com.app.dto.MatchDTO;
import com.app.service.IMatchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

@RestController
@RequestMapping("/match")
@CrossOrigin(origins = "http://localhost:3000")
public class MatchContoller {

	@Autowired
	IMatchService matchService;
		
	@PostMapping("/{series}")
	ResponseEntity<?> addMatch(@RequestBody MatchDTO matchDTO,@PathVariable String series){
	   return	ResponseEntity.status(HttpStatus.CREATED).body(matchService.addMatch(matchDTO ,series));
	}

	@PostMapping("/players")
	ResponseEntity<?>  addPlayers(@RequestBody ListDTO dto){	
	//	System.out.println(dto.getList());
	   return	ResponseEntity.status(HttpStatus.CREATED).body(matchService.addPlaying11(dto.getList()));
	}
	
	@GetMapping
	ResponseEntity<?> getPlaying11(){
		return ResponseEntity.status(HttpStatus.OK).body(matchService.getPlaying11());
//		System.out.println(matchService.getPlaying11());
//		return "ok";
	}
	
	
}
