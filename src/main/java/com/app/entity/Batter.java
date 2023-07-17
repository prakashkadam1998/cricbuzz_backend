package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString (exclude= {"inning"})
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Batter extends BaseEntity{

	// Player Batter R B 4s  6s SR
	@OneToOne
	@JoinColumn(name="player_id")
	Profile playerName;
	int run;
	int ball;
	int bounderies;
	int six;
	
	// throws exceptions if values null
	@Formula(value="(run / ball ) *100")
	float strikeRate;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="inning_id")
	Inning inning;
	
}
