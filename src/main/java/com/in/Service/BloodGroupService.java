package com.in.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.in.Entity.BloodGroup;

import jakarta.validation.Valid;

public interface BloodGroupService {

	BloodGroup saveBlood(@Valid BloodGroup bloodgroup);

	List<String> getAllBloodGroups();
	
	BloodGroup addBloodGroup(String bloodgroup);
	
//Extra code	
	
	List<BloodGroup> getAllBloodGroup_json();


	

}
