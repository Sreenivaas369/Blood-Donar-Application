package com.in.ServiceImpl;

import com.in.Entity.Address;
import com.in.Repository.AddressRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {

        @Mock
        private AddressRepository addressRepository;

        @InjectMocks
        private AddressServiceImpl addressServiceImpl;

        //For the successfully getting method

        @Autowired
        private Address address;


    @Test
    public  void postAllData_success(){
        Address address1=new Address();
        address1.setCountry("India");

        given(addressRepository.save(address1)).willReturn(address1);
        address1.setCountry("India");
        Address a=addressServiceImpl.saveAddress(address1);
        assertEquals(a,address1);
    }

    @Test
    public void getAllCountries_Success(){
        List<String> l1=new ArrayList<>();
        l1.add("India");
        l1.add("Uk");
        l1.add("Sri Lanka");

        when(addressRepository.getCountryList()).thenReturn(l1);
        List<String> l2=addressServiceImpl.getCountryList();
        assertEquals(l1,l2);
    }
    @Test
    @Disabled
    public void getAllCountries_Failure(){
        List<String> l1=new ArrayList<>();
        l1.add("India");
        l1.add("Uk");
        l1.add("Sri Lanka");

        when(addressRepository.getCountryList()).thenReturn(l1);
        List<String> l2=addressServiceImpl.getCountryList();
        assertEquals(l1,l2);
    }

    @Test
    public void getStateList_Success(){
        List<String> l1=new ArrayList<>();
        l1.add("Andhra");
        l1.add("Telangana");
        l1.add("Karnataka");

        when(addressRepository.findByCountry("India")).thenReturn(l1);
        List<String> l2=addressServiceImpl.getStateList("India");
        assertEquals(l1,l2);
    }
    @Test
    public void getDistrictList_Success(){
        List<String> l1=new ArrayList<>();
        l1.add("Prakasam");
        l1.add("Nellore");
        l1.add("Kadapa");

        when(addressRepository.findByState("Andhra Pradesh")).thenReturn(l1);
        List<String> l2=addressServiceImpl.getDistrictList("Andhra Pradesh");
        assertEquals(l1,l2);
    }
    @Test
    public void getCityList_Success(){
        List<String> l1=new ArrayList<>();
        l1.add("Podhili");
        l1.add("CSPuram");
        l1.add("Pamuru");

        when(addressRepository.findByDistrict("Ongole")).thenReturn(l1);
        List<String> l2=addressServiceImpl.getCityList("Ongole");
        assertEquals(l1,l2);
    }
}