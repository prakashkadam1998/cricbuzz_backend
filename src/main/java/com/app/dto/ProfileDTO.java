package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.entity.ProfileStats;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileDTO {

	private String firstName;	

	private String lastName;	
		
	private LocalDate birthDate;

	private String birthPlace;

	private int height;

	private String gender;

	private String role;

	private String battingStyle;

	private String bowlingStyle;

	private String teams;

	private String imageURL;    
	
	private List< ProfileStats> profileStats;

}
