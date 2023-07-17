package com.app.service;

import java.util.List;

import com.app.dto.MatchDTO;
import com.app.entity.Profile;

public interface IMatchService {

	String addMatch(MatchDTO matchDTO,String series);
	String addPlaying11(List<String> names);
	List<Profile>  getPlaying11();
}
