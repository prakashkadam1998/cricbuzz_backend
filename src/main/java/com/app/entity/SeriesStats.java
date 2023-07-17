 package com.app.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//POINTS TABLE
@Getter
@Setter
@ToString     (exclude = {"series","profiles","team"})
@Entity
@Table(name="series_stats")
public class SeriesStats extends BaseEntity{
//Mat Won Lost Tied NR Pts NRR League year image shortName(LSG) squads
//	String teamName;
//	String shortName;
//	String img;
	
	
	private int matchesPlayed;

	private int won ;
	
	private int lost;
	
	private int tied;
	
	private int noResult;
	
	private int points;
	
	private float NRR;
	
	private int year;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String groupName; // south/north
	
	@ManyToOne     //(fetch = FetchType.LAZY)
	@JoinColumn(name="series_id",foreignKey =@ForeignKey(name ="SERIES_ID_FK" ))
	Series series;

	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="squad", joinColumns = @JoinColumn(name="team_id"),inverseJoinColumns = @JoinColumn(name="profile_id"))
     private List<Profile> profiles = new ArrayList<>() ;    // squad of 11 or 20

	@ManyToOne          //(fetch = FetchType.LAZY)
	@JoinColumn(name="team_id", foreignKey = @ForeignKey(name="TEAM_ID_FK"))
	Team team;  // abstract 
//	
/////////	@OneToMany
////	List<Venue> venues = new ArrayList<Venue>();
//	// or can on venue side also
//	
	
	
	
}
