package com.app.entity;



import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Series extends BaseEntity{
	
	String name;
	String Type;   // T10,T20,ODI,TEST,THE100
	String level;   // international , domestic
//	int year;
//	Date startDate;
//	Date endDate;
	
	
}
