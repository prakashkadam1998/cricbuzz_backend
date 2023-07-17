package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ISeriesStatsDao;
import com.app.dto.SeriesDTO;
import com.app.dto.SeriesStatsDTO;
import com.app.service.ISeriesService;

@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "http://localhost:3000")
public class SeriesController {

	@Autowired
	ISeriesService seriesService;
	
	
	
	@PostMapping
	ResponseEntity<?>addSeries(@RequestBody SeriesDTO dto){
	return ResponseEntity.status(HttpStatus.CREATED).body( seriesService.addSeries(dto));
	}
	
	
	@GetMapping("/{seriesName}")
	ResponseEntity<?>getSeries(@PathVariable String seriesName){
		return ResponseEntity.status(HttpStatus.OK).body(seriesService.getSeriesDetails(seriesName));
	}
	
	@PostMapping("/addStats")
	ResponseEntity<?>addSeriesStats(@RequestParam String seriesName,@RequestParam String teamName,@RequestBody SeriesStatsDTO statsDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.addSeriesStats(statsDTO, seriesName,teamName));
	}
	
	@GetMapping("/getStats")
	ResponseEntity<?> getSeriesStats(@RequestParam String seriesName,@RequestParam("date")  @DateTimeFormat(pattern = "yyyy-MM-dd") 
    LocalDate date){
		return ResponseEntity.status(HttpStatus.OK).body(seriesService.getSeriesStatsByDate(date, seriesName));
	}
	
	@PostMapping("/addSquad")
	ResponseEntity<?> addSquad(@RequestParam String seriesName,@RequestParam String teamName,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate date  ,@RequestParam Long profileId){
		System.out.println(profileId);
		return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.addSquadProfiles(date, seriesName, teamName, profileId));
	}
	
	@GetMapping("/getSquad")
	ResponseEntity<?>getSquad(@RequestParam String seriesName,@RequestParam String teamName,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
		return ResponseEntity.status(HttpStatus.OK).body(seriesService.getSquad(date, seriesName, teamName));
	}
}
