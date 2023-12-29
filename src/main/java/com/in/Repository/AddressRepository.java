package com.in.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.Entity.Address;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, Integer> {


	@Query(value = "select distinct(country) from Address", nativeQuery = true)
	List<String> getCountryList();

	@Query(value = "select distinct(state) from Address where country=:country", nativeQuery = true)
	List<String> findByCountry(String country);

	@Query(value = "select distinct(district) from Address where state=:state", nativeQuery = true)
	List<String> findByState(String state);

	@Query(value = "select distinct(city) from Address where district=:district", nativeQuery = true)
	List<String> findByDistrict(String district);

	// For Registration
	Address findByCity(String city);
}