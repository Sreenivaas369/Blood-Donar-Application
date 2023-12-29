package com.in.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.Entity.Donar;

@Repository
public interface DonarRepository extends JpaRepository<Donar, Integer> {

	//select * from Donar d join address a on d.addressid=a.addressid where country=:country and :state is null or state=:state and :district is null or district=:district and :city is null or city=:city;
	
	@Query("select d from Donar d where d.address.country=:country and :state is null or d.address.state=:state and :district is null or d.address.district=:district and :city is null or d.address.city=:city and d.bloodgroup.bloodgroup=:bloodgroup")
	List<Donar> searchDonars(String country, String state, String district, String city, String bloodgroup);

	//select * from donar d join address a on d.addressid=a.addressid and join bloodgroup b on d.bloodgroupid=b.bloodgroupid where city="chennai";
	
	@Query("select d from Donar d where d.address.city=:city and d.bloodgroup.bloodgroup=:bloodgroup")
	List<Donar> searchDonarDetails(String city, String bloodgroup);
	
	// TO check the data exist or not
	
	@Query("select d from Donar d where d.address.city=:city and d.bloodgroup.bloodgroup=:bloodgroup")
	List<Donar> checkDataCityAndBlood(String city,String bloodgroup);
	
	@Query("select d from Donar d where d.address.country=:country and d.bloodgroup.bloodgroup=:bloodgroup")
	List<Donar> checkDataCountryAndBlood(String country, String bloodgroup);
	
//Extra Code	
	
	@Query("select d from Donar d where d.address.country=?1")
	List<Donar> getDataByCountry(String country);

	@Query("select d from Donar d where d.bloodgroup.bloodgroup=?1")
	List<Donar> getDataByBlood(String bloodgroup);


	

	

}
