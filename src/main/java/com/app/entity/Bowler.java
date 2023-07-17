package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Formula;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Bowler extends BaseEntity{

	//Bowler O M R W NB WD ECO
	@OneToOne
	@JoinColumn(name="player_id")
	Profile playerName;
	
	double overs;
	int maiden;
	int run;
	short wicket;
	int noBall;
	int wide;
	
	@Formula("run / over")
	float economy;	
	
	@ManyToOne
	@JoinColumn(name="inning_id")
	Inning inning;
	
}
