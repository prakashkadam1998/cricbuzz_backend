package com.app.dto;

import java.time.LocalDate;

import com.app.entity.Team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//POINTS TABLE

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SeriesStatsDTO {
//Mat Won Lost Tied NR Pts NRR League year image shortName(LSG) squads
//	String teamName;
//	String shortName;
//	String img;

	int matchesPlayed;

	int won;

	int lost;

	int tied;

	int noResult;

	int points;

	float NRR;

	int year;

	LocalDate startDate;

	LocalDate endDate;

	SeriesDTO series;

	String groupName; // south/north
	
	///// List<Squad> squad; // squad of 11 or 20


	TeamDTO team; // abstract

//	List<Venue> venues = new ArrayList<Venue>();
	// or can on venue side also

}
