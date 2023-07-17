package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IProfileDao;
import com.app.dto.ProfileDTO;
import com.app.entity.ProfileStats;
import com.app.entity.Profile;
import com.app.service.IProfileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:3000")
//@Slf4j
public class ProfileController {

	@Autowired
	IProfileService service;
	@Autowired
	IProfileDao dao;
	
	@GetMapping("/get/{id}")
   ResponseEntity<?> getProfile(@PathVariable Long id) {
		return ResponseEntity.ok(service.getDetails(id));
		//return ResponseEntity.ok(dao.findById(id));
		
	}
	
	@PostMapping("/save")
	ResponseEntity<?> addDetails(@RequestBody ProfileDTO profileDTO) {
return	ResponseEntity.status(HttpStatus.CREATED).body(service.addProfile(profileDTO)) ;
	}
	
	
	@PostMapping("/save/{id}")
	ResponseEntity<?> addStats(@PathVariable Long id, @RequestBody ProfileStats stats) {
return	ResponseEntity.status(HttpStatus.CREATED).body(service.addStats(stats,id)) ;
	}
}





//Note that @PathVariable is used to capture values from the URL path, 
//whereas @RequestParam is used to retrieve values from query parameters,
//form data, or request headers. @PathVariable is typically used when you 
// want to capture values that are part of the URL path, such as IDs, slugs, or other dynamic parts of the URL.
//@RequestParam captures values from the query parameters or form 
// parameters in the URL, which are usually appended to the URL after a “?” symbol.
// For example: “/users?name=john&age=30”. On the other hand, @PathVariable captures values from the URL path itself, which is usually separated by slashes (“/”). For example: “/users/{id}”.