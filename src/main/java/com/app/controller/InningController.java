package com.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Batter;
import com.app.service.IInningService;

@RestController
@RequestMapping("/inning")
public class InningController {
	
	@Autowired
	IInningService inningService;

	@PostMapping("/addInning")
	ResponseEntity<?> addInning(@RequestParam long id,@RequestParam String batter1, @RequestParam String batter2,@RequestParam String bowler){
		return ResponseEntity.status(HttpStatus.CREATED).body(inningService.addInning(id, batter1, batter2, bowler));
	}
	@PostMapping("/addBatter")
	ResponseEntity<?> addBatter(@RequestParam long inningId,@RequestParam long batterId, @RequestBody Batter batter ){
		return ResponseEntity.status(HttpStatus.CREATED).body(inningService.addBatter(inningId,batterId, batter));
	}
	
	
	@PatchMapping("/{id}")
	ResponseEntity<?> updateBatter(@PathVariable long id,@RequestBody Map<String,Object> map){
		System.out.println(id+" "+map);
		return ResponseEntity.status(HttpStatus.OK).body(inningService.updateBatter(id, map));
	}
	
	@GetMapping("/getBatters/{inningId}")
	ResponseEntity<?> getBatter(@PathVariable long inningId){
		return ResponseEntity.status(HttpStatus.CREATED).body(inningService.getBatters(inningId));
	}
}
