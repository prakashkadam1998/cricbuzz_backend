package com.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "overs")
public class Over extends BaseEntity{
	int numbers;
//	List <Ball> balls;
	
	@ManyToOne 
	@JoinColumn(name="inning_id",foreignKey = @ForeignKey(name="FK_OVER_INNING"))
	Inning inning ;
}
