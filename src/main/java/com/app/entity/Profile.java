package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"profileStats"})
@Entity
@Table(name = "Profiles")
public class Profile extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "birth_place", length = 50)
	private String birthPlace;

	@Column(length = 10)
	private int height;

	@Column(length = 20)
	private String gender;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "batting_style")
	private String battingStyle;

	@Column(name = "bowling_style")
	private String bowlingStyle;

	
	private String teams;

	@Column(name = "image_url")
	private String imageURL; // store one image using io also
	//@JsonManagedReference
	
	@JsonIgnore
	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List< ProfileStats> profileStats = new ArrayList<>(); // T20,Test

//alter table profiles add constraint FKtc30tj7on7otkrkf5htshktca foreign key (stats_id) references player_stats (id)

	public void addProfileStats(ProfileStats profileStat) {
		profileStats.add(profileStat);
		profileStat.setProfile(this);
	}

	public void removeProfileStats(ProfileStats profileStat) {
		profileStats.remove(profileStat);
		profileStat.setProfile(null);
		}
}



