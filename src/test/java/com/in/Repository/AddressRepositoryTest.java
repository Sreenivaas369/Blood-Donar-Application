package com.in.Repository;


import com.in.Entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;
    Address address;

    @BeforeEach
    public void SetUp(){
        address=new Address(1,"India","Andhra Pradesh","Praksam","Ongole","12-12-12");
        addressRepository.save(address);
    }

    @AfterEach
    void tearDown() {
        address=null;
        addressRepository.deleteAll();
    }


    //Test Case For Success

//    @Test
//    public void testAllCityByCountry_Success() {
//        List<String> stateList=  addressRepository.findByCountry("India");
//
//
//    }

    //Test Case Failure



}

