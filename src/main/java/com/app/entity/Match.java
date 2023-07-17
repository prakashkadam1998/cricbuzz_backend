package com.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString   //(exclude = {"innings","series","playingTeams"})
@Entity
@Table(name="matches")

public class Match extends BaseEntity {

	
	
    LocalDateTime startDateTime;
	LocalDate seriesStart;   //series for every year
	@OneToMany(mappedBy = "match" ,cascade = CascadeType.ALL,orphanRemoval = true)
	List<Inning> innings; // test 4 innings
	
	
//	MatchType matchType; // test , t20
//	Venue venue;
	
	
	// Toss and many match info
	@ManyToOne     //(fetch = FetchType.LAZY)
	@JoinColumn(name="series_id",foreignKey =@ForeignKey(name ="MATCH_SERIES_FK" ))
	Series series;
//	Team a;
//	Team b;
	@OneToMany     //(fetch = FetchType.LAZY)
	private List<PlayingTeam> playingTeams;  // 2 teams
	
	
	public void addInning(Inning inning) {
		innings.add(inning);
		inning.setMatch(this);
	}
	
	public void removeInning(Inning inning) {
		innings.remove(inning);
		inning.setMatch(null);
	}
	
}
