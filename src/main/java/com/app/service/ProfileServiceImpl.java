package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IProfileDao;
import com.app.dao.IProfileStatsDao;
import com.app.dto.ProfileDTO;
import com.app.entity.ProfileStats;
import com.app.entity.Profile;

@Service
@Transactional
public class ProfileServiceImpl implements IProfileService{

	@Autowired
	IProfileDao dao;
	@Autowired
	IProfileStatsDao statsDao;
	
@Autowired
private ModelMapper mapper;
	
	@Override
	public String addProfile(ProfileDTO profile) {
		
		Profile profileEntity =mapper.map(profile,Profile.class);
		dao.save(profileEntity);
		return "Details Added Succesfully";
	}
	
	@Override
	public String addStats(ProfileStats stats,Long id) {
		Profile profile=dao.findById(id).orElseThrow(()->new RuntimeException("Profile not Found....."));
		profile.addProfileStats(stats);
		statsDao.save(stats);
		return null;
	}
	
	
	@Override
	public ProfileDTO getDetails(Long id) {
		System.out.println("* id="+id);
	Profile profile=dao.findById(id).orElseThrow(()->new RuntimeException("Profile not Found....."));
	//System.out.println("......."+profile); **See StackoverFlow Error
	//	Optional<Profile> profile=dao.getProfile(id);
		return mapper.map(profile, ProfileDTO.class);
	}

		
}
