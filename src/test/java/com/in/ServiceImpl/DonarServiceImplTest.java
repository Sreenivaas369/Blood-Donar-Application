package com.in.ServiceImpl;

import com.in.Entity.Address;
import com.in.Entity.BloodGroup;
import com.in.Entity.Donar;
import com.in.Entity.User;
import com.in.Repository.DonarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DonarServiceImplTest {


    @Mock
    private DonarRepository donarRepository;

    @InjectMocks
    private DonarServiceImpl donarService;

    private Donar donar;

    @BeforeEach
    void setUp() {
    donar=Donar.builder()
            .fullname("Sreenivasulu")
            .donarid(1)
            .mobilenumber(7647490840l)
            .acknowledgement(true)
            .availability(true)
            .user(new User("Sreenivas@gmail.com","Sree@123","12-12-23"))
            .bloodgroup(new BloodGroup(11,"B+"))
            .address(new Address(111,"Indian","Telangana","Hyderabad","KPHB","12-12-23"))
            .date("12-12-23")
            .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registration() {

        given(donarRepository.save(donar)).willReturn(donar);

        Donar Expected=donarService.Registration(donar);

        assertThat(Expected).isNotNull();


    }

    @Test
    void searchDonars() {

        when(donarRepository.searchDonars("India","Telangana","Hyderabad","KPHB","A+")).thenReturn(List.of(donar));

        List<Donar> Expected_list=donarService.searchDonars("India","Telangana","Hyderabad","KPHB","A+");

        assertThat(Expected_list).isNotNull();

       assertEquals(Expected_list,List.of(donar));

    }

    @Test
    void searchDonarDetails() {

        when(donarRepository.searchDonarDetails("KPHB","A+")).thenReturn(List.of(donar));

        List<Donar> Expected_list=donarService.searchDonarDetails("KPHB","A+");

        assertThat(Expected_list).isNotNull();

    }

    @Test
    void checkDataCityAndBlood() {

        when(donarRepository.checkDataCityAndBlood("KPHB","A+")).thenReturn(List.of(donar));

        List<Donar> Expected_list=donarService.checkDataCityAndBlood("KPHB","A+");

        assertThat(Expected_list).isNotNull();

    }

    @Test
    void checkDataCountryAndBlood() {

        when(donarRepository.checkDataCountryAndBlood("India","A+")).thenReturn(List.of(donar));

        List<Donar> Expected_list=donarService.checkDataCountryAndBlood("India","A+");

        assertThat(Expected_list).isNotNull();
    }

    @Test
    void getDonarByCountry() {

        when(donarRepository.getDataByCountry("India")).thenReturn(List.of(donar));

        List<Donar> Expected_list=donarService.getDonarByCountry("India");

        assertThat(Expected_list).isNotNull();

    }

    @Test
    void getDonarDetailsByBloodGroup() {
        when(donarRepository.getDataByBlood("India")).thenReturn(List.of(donar));

        List<Donar> Expected_list=donarService.getDonarDetailsByBloodGroup("India");

        assertThat(Expected_list).isNotNull();

    }
}