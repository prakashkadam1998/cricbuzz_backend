package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

	@Column(name="team_name")
	private String teamName;
	
	@Column(name="short_name")
	private String shortName ;
	private String country ;
	//private int year;
	private String image;
	private String type;  //women
	//private String series;
	
	 
	
	
}
