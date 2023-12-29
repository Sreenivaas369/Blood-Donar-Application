package com.in.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.in.Entity.Donar;
import com.in.Repository.DonarRepository;
import com.in.Service.DonarService;

@Service
public class DonarServiceImpl implements DonarService{

	@Autowired
	private DonarRepository dRepo;

	@Override
	public Donar Registration(Donar donar) {
		return dRepo.save(donar);
	}
	
	@Override
	public List<Donar> searchDonars(String country, String state, String district, String city, String bloodgroup) {
		return dRepo.searchDonars(country, state, district, city, bloodgroup);
	}

	@Override
	public List<Donar> searchDonarDetails(String city, String bloodgroup) {
		// TODO Auto-generated method stub
		return dRepo.searchDonarDetails(city, bloodgroup);
	}
	
	//TO Check the Data
	
	@Override
	public List<Donar> checkDataCityAndBlood(String city, String bloodgroup) {
		// TODO Auto-generated method stub
		return dRepo.checkDataCityAndBlood(city,bloodgroup);
	}
	
	@Override
	public List<Donar> checkDataCountryAndBlood(String country, String bloodgroup) {
		// TODO Auto-generated method stub
		return dRepo.checkDataCountryAndBlood(country,bloodgroup);
	}
	
	
// Extra Code
	
	@Override
	public List<Donar> getDonarByCountry(String country) {
		// TODO Auto-generated method stub
		return dRepo.getDataByCountry(country);
	}

	@Override
	public List<Donar> getDonarDetailsByBloodGroup(String bloodgroup) {
		return dRepo.getDataByBlood(bloodgroup);
	}


	


}
