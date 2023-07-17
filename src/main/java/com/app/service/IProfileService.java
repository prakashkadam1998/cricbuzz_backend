package com.app.service;

import com.app.dto.ProfileDTO;
import com.app.entity.ProfileStats;

public interface IProfileService {

	  String addProfile(ProfileDTO profile);
	  String addStats(ProfileStats stats, Long id);
	  ProfileDTO getDetails(Long id);
	  
}
