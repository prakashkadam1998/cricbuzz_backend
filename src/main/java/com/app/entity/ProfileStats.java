package com.app.entity;

import javax.persistence.Column;
import  javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import  javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="profile_stats")
public class ProfileStats extends BaseEntity {
	
	@Column()
	int matches;
	
	int innings;
	
	int NO;
	@Column(name="bat_runs")
	int batRuns;
	@Column(name="highest_score")
	int highestScore;
	
	@Column(name="bat_average")
	float batAverage;
	
	@Column(name="best_figure")
	int bestFigure;
	
	
	float batSR;
	
	int century;
	@Column(name="double_century")
	int doubleCentury;
	
	
	int fifty;
	
	int bounderies;
	
	int sixes;
	@Column(name="bowl_innings")
	int bowlInnings;
	
	int balls;
	@Column(name="bowl_runs")
	int bowlRuns;
	
	int wickets;
	
	int BBI;
	
	int BBM;
	//M BatInnings NO BatRuns HS BatAvg BestFigure BatSR 100 200 50 4s 6s BowlInnings 
//	Balls BowlRuns Wkts BBI BBM Econ BowlAvg BowlSR 5W 10W
	
	float economy;
	@Column(name="bowl_average")
	float bowlAverage;
	
	float bowlSR;
	
	int wicket5;
	
	int wicket10;
	//@JsonBackReference
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="profile_id",foreignKey = @ForeignKey(name="FK_PROFILE_STATS"))
	private Profile profile;
	
	
}
