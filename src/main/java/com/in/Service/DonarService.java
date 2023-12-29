package com.in.Service;

import java.util.List;

import com.in.Entity.Donar;


public interface DonarService {

	Donar Registration(Donar donar);
	
	List<Donar> searchDonars(String country, String state, String district, String city, String bloodgroup);

	List<Donar> searchDonarDetails(String city, String bloodgroup);

	//For checking Data exist or not 
	
	List<Donar> checkDataCityAndBlood(String city, String bloodgroup);
	
	List<Donar> checkDataCountryAndBlood(String country, String bloodgroup);
	
//Extra code

	List<Donar> getDonarByCountry(String country);

	List<Donar> getDonarDetailsByBloodGroup(String bloodgroup);

	



}
