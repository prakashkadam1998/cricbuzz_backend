package com.app.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.dto.ProfileDTO;
import com.app.entity.Profile;



@Repository
public interface IProfileDao extends JpaRepository<Profile, Long>{

//	@Query("select p from Profile p")
//    Optional<Profile> getProfile(long userId);
	
	Profile findByFirstName(String name);
	Profile findByFirstNameAndLastName(String firstName, String LastName);
}
