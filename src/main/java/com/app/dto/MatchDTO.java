package com.app.dto;

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

import com.app.entity.Inning;
import com.app.entity.PlayingTeam;
import com.app.entity.Series;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString   //(exclude = {"innings","series","team"})

public class MatchDTO extends BaseDTO{

	
	
    LocalDateTime startDateTime;
	LocalDate seriesStart;   //series for every year
	
	List<Inning> innings; // test 4 innings

	Series series;

	private List<PlayingTeam> teamPlayers;  // 2 teams
	
	
}
