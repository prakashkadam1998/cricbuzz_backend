package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = { "overs","match","batters","bowlers"})
@Entity
public class Inning extends BaseEntity{

	// Player Batter R B 4s  6s SR
	
	@OneToMany(mappedBy = "inning", cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Batter> batters = new ArrayList<>();
	
	@OneToMany(mappedBy = "inning", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bowler>bowlers = new ArrayList<>();
	
	@OneToMany(mappedBy = "inning",cascade = CascadeType.ALL,orphanRemoval = true)
	List<Over> overs = new ArrayList<>();
	
	
	//List<Wicket> wickets= new ArrayList<>();

	@ManyToOne()
	@JoinColumn(name = "match_id",foreignKey = @ForeignKey(name="FK_INNING_MATCH"))
	Match match;
	
	
	
	
	//Utility Methods
	public void addBatter (Batter batter) {
		batters.add(batter);
		batter.setInning(this);;
	}
	
	public void removeBatter(Batter batter) {
		batters.remove(batter);
		batter.setInning(null);
	}
	
	public void addBowler (Bowler bowler) {
		bowlers.add(bowler);
		bowler.setInning(this);;
	}
	
	public void removeBowler(Bowler bowler) {
		bowlers.remove(bowler);
		bowler.setInning(null);
	}
}