package com.in.Service;

import java.util.List;
import java.util.Set;

import com.in.Entity.Address;

import jakarta.validation.Valid;

public interface AddressService {


	List<String> getCountryList();

	List<String> getStateList(String country);

	List<String> getDistrictList(String state);

	List<String> getCityList(String district);

	Address findByCity(String city);
//For Registration
	Address AddAddress(String country, String state, String district, String city);
	
//Extra Code
	
	Address saveAddress(@Valid Address address);

}
