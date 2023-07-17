package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeamDTO {

    private String teamName;

	private String shortName ;
	private String country ;
	
	private String image;
	private String type;  // women men
}
