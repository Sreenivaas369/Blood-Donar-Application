package com.in.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.Entity.Address;
import com.in.Entity.BloodGroup;
import com.in.Entity.Donar;
import com.in.Entity.User;
import com.in.ExceptionHandler.InvalidPasswordException;
import com.in.Request.DonarRequest;
import com.in.Request.DonarResponse;
import com.in.Service.AddressService;
import com.in.Service.BloodGroupService;
import com.in.Service.DonarService;
import com.in.Service.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
public class DonarController {

	@Autowired
	private DonarService dService;
	@Autowired
	private AddressService aService;

	@Autowired
	private BloodGroupService bService;

	@Autowired
	private UserService uService;
	
	// To Registration of Donar

	@PostMapping("/donar/Registration")
	public ResponseEntity<Donar> Registration(@Valid @RequestBody DonarRequest donarrequest) throws InvalidPasswordException {
		Donar donar = new Donar();
		if(donarrequest.getPassword().equals(donarrequest.getConfirmPassword())) {
			donar.setFullname(donarrequest.getFullname());
			donar.setMobilenumber(donarrequest.getMobilenumber());
			donar.setAvailability(donarrequest.isAvailability());
			donar.setAcknowledgement(true);

			BloodGroup bloodGroup = bService.addBloodGroup(donarrequest.getBloodgroup());

			Address address = aService.AddAddress(donarrequest.getCountry(), donarrequest.getState(),
					donarrequest.getDistrict(), donarrequest.getCity());
			User user = uService.AddUser(donarrequest.getUserid(), donarrequest.getPassword());

			donar.setUser(user);
			donar.setAddress(address);
			donar.setBloodgroup(bloodGroup);
			
			return new ResponseEntity<>(dService.Registration(donar), HttpStatus.CREATED);
		}
		else {
			throw new InvalidPasswordException("Password and Confirm Password Should be Match");
		}
		
	}
	
	@GetMapping("/getDonarDetails")
	public ResponseEntity<List<DonarResponse>> searchDonars(@RequestParam(required = true) String country,
			@RequestParam(required = false) String state, @RequestParam(required = false) String district,
			@RequestParam(required = false) String city, @RequestParam(required = true) String bloodgroup) {
		List<DonarResponse> list=new ArrayList<>();
		List<Donar> donar=dService.checkDataCountryAndBlood(country,bloodgroup);
		if(donar.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}
		for(Donar i :donar) {
			DonarResponse response=DonarResponse.build(i.getFullname(), i.getBloodgroup().getBloodgroup(),i.getMobilenumber(), i.getUser().getUserid(),i.isAvailability(), i.getAddress().getCountry(), i.getAddress().getState(), i.getAddress().getDistrict(), i.getAddress().getCity(), i.getDate());
			list.add(response);
		}	
		dService.searchDonars(country, state, district, city, bloodgroup);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getDonarDetailsResponse")
	public ResponseEntity<List<DonarResponse>> searchDonarDetails(@RequestParam(required = true) String city,
			@RequestParam(required = true) String bloodgroup) {
		List<DonarResponse> list=new ArrayList<>();
		List<Donar> donar=dService.checkDataCityAndBlood(city,bloodgroup);
		if(donar.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}
		for(Donar i :donar) {
			DonarResponse response=DonarResponse.build(i.getFullname(), i.getBloodgroup().getBloodgroup(),i.getMobilenumber(), i.getUser().getUserid(),i.isAvailability(), i.getAddress().getCountry(), i.getAddress().getState(), i.getAddress().getDistrict(), i.getAddress().getCity(), i.getDate());
			list.add(response);
		}	
		dService.searchDonarDetails(city, bloodgroup);
		return new ResponseEntity<>(list,HttpStatus.OK);

	}
	
	
//Extra code	
	

	@GetMapping("/getDonaByCountry")
	public ResponseEntity<List<Donar>> getDonarByCountry(@RequestParam String country) {
		return new ResponseEntity<>(dService.getDonarByCountry(country), HttpStatus.OK);

	}

	@GetMapping("/getDonarByBloodGroup")
	public ResponseEntity<List<Donar>> getDonarByBloodGroupId(@RequestParam String bloodgroup) {
		return new ResponseEntity<>(dService.getDonarDetailsByBloodGroup(bloodgroup), HttpStatus.OK);

	}

	

}
