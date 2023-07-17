package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
public class PlayingTeam extends BaseEntity{

	@OneToOne
	@JoinColumn(name = "team_id")
	Team team;

	@OneToMany(fetch = FetchType.EAGER) // try adding match for india series & see if allow to add
	private List<Profile> playing11 = new ArrayList<>();  // can use Set<>
}





//From the JPA 2.0 spec, the defaults are:
//
//OneToMany: LAZY
//ManyToOne: EAGER
//ManyToMany: LAZY
//OneToOne: EAGER
//And in hibernate, all is Lazy
//
//UPDATE:
//
//The latest version of Hibernate aligns with the above JPA defaults.
