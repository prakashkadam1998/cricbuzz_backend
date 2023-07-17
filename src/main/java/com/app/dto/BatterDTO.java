package com.app.dto;

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

public class BatterDTO extends BaseDTO{


//	@JoinColumn(name="player_id")
//	Profile playerName;
	int run;
	int ball;
	int bounderies;
	int six;
	
	
	float strikeRate;
	
//	@ManyToOne
//	@JoinColumn(name="inning_id")
//	Inning inning;
//	
}
