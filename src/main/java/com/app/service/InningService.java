package com.app.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.app.dao.IBatterDao;
import com.app.dao.IInnningDao;
import com.app.dao.IMatchDao;
import com.app.dao.IProfileDao;
import com.app.dto.BatterDTO;
import com.app.dto.MatchDTO;
import com.app.entity.Batter;
import com.app.entity.Bowler;
import com.app.entity.Inning;
import com.app.entity.Match;
import com.app.entity.Profile;
import com.app.exception_handler.ResourceNotFoundException;

@Transactional
@Service
public class InningService implements IInningService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	IInnningDao innningDao;

	@Autowired
	IMatchDao matchDao;

	@Autowired
	IProfileDao profileDao;
	
	@Autowired
	IBatterDao batterDao;

	@Override
	public String addInning(long id, String batter1, String batter2, String bowler) {
		String[] batter1Names = batter1.split("\\s+");
		String[] batter2Names = batter2.split("\\s+");
		String[] bowlerNames = bowler.split("\\s+");

//		System.out.println(name[0]);

		Profile profile1 = profileDao.findByFirstNameAndLastName(batter1Names[0], batter1Names[1]);
		Profile profile2 = profileDao.findByFirstNameAndLastName(batter2Names[0], batter2Names[1]);
		Profile profile3 = profileDao.findByFirstNameAndLastName(bowlerNames[0], bowlerNames[1]);
		// System.out.println(profile);

		Batter batterEntity1 = new Batter();
		batterEntity1.setPlayerName(profile1);
		Batter batterEntity2 = new Batter();
		batterEntity2.setPlayerName(profile2);
		Bowler bowlerEntity = new Bowler();
		bowlerEntity.setPlayerName(profile3);

		Inning inning = new Inning();
		inning.addBatter(batterEntity1);
		inning.addBatter(batterEntity2);
		inning.addBowler(bowlerEntity);
		Match match = matchDao.findById(id).orElseThrow(() -> new RuntimeException("Match Not found"));
		match.addInning(inning);
		matchDao.save(match);

		return "Inning with 2 Batter & 1 Bowler added";
	}

	@Override
	public String updateBatter(long id, Map<String,Object> values) {
	 Batter batter =  batterDao.findById(id).orElseThrow(()->new RuntimeException("Batter not found"));
		 values.forEach((key,value)->{
			 Field field = ReflectionUtils.findRequiredField(Batter.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, batter, value);
		 });	 
		 batterDao.save(batter);
		 System.out.println(batter);
		 
		 return "Batter Details updated";
	}

	@Override
	public String addBatter(long inningId,long batterId, Batter batter) {
	// Batter bat=  mapper.map(batter, Batter.class);
	   Profile profile =	profileDao.findById(batterId).orElseThrow(()->new ResourceNotFoundException("Player not found"));
		batter.setPlayerName(profile);
		Inning inning = innningDao.findById(inningId).orElseThrow(()->new ResourceNotFoundException("Inning not found"));
		inning.addBatter(batter);
		System.out.println(batter);
		innningDao.save(inning);
	 
		return "Batter added in Inning";
	}

	@Override
	public List<Batter> getBatters(long inningId) {
		Inning inning = innningDao.findById(inningId).orElseThrow(()->new ResourceNotFoundException("Inning not found"));
		System.out.println(inning.getBatters());
		//return null;
		return inning.getBatters();
	}
	
}
