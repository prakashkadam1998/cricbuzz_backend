package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.entity.Batter;

public interface IInningService {

	String addInning(long id, String Batter1,String Batter2, String Bowler);
	String updateBatter(long id,Map<String,Object> values);
	String addBatter(long inningId,long batterId,Batter batter);
	List<Batter> getBatters(long inningId);
}
