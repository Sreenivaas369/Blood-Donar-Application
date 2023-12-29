package com.in.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.Entity.BloodGroup;
import com.in.Service.BloodGroupService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
public class BloodGroupController {

	@Autowired
	private BloodGroupService bService;

	
	@GetMapping("/GetBloodGroups")
	public ResponseEntity<List<String>> getAllBloodGroups() {
		return new ResponseEntity<>(bService.getAllBloodGroups(),HttpStatus.CREATED);

	}

	@PostMapping("/AddBloodGroup")
	public ResponseEntity<BloodGroup> AddBloodGroup(@Valid @RequestBody BloodGroup bloodgroup) {
		return new ResponseEntity<>(bService.saveBlood(bloodgroup),HttpStatus.CREATED);
	}
	

//Extra Code
	
	@GetMapping("/GetAllBloodGroup")
	public ResponseEntity<List<BloodGroup>> getAllBloodGroup_json() {
		return new ResponseEntity<>(bService.getAllBloodGroup_json(),HttpStatus.OK);
	}

	

}
