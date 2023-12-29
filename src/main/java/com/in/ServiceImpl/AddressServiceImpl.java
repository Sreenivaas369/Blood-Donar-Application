package com.in.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.Entity.Address;
import com.in.Repository.AddressRepository;
import com.in.Service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository aRepo;
	@Override
	public Address saveAddress(Address address) {
		return aRepo.save(address);
	}

	@Override
	public List<String> getCountryList() {
		return aRepo.getCountryList();
	}
	@Override
	public List<String> getStateList(String country) {
		return aRepo.findByCountry(country);
	}
	@Override
	public List<String> getDistrictList(String state) {
		return aRepo.findByState(state);
	}
	@Override
	public List<String> getCityList(String district) {
		return aRepo.findByDistrict(district);
	}

	

// For Registration

	public Address AddAddress(String country, String state, String district, String city) {

		Address checkaddress = aRepo.findByCity(city);
		if (checkaddress != null) {
			return checkaddress;
		}
		Address address = new Address();
		address.setCountry(country);
		address.setState(state);
		address.setDistrict(district);
		address.setCity(city);
		return aRepo.save(address);
	}


//Extra Code
	@Override
	public Address findByCity(String city) {
		return aRepo.findByCity(city);
	}

}
