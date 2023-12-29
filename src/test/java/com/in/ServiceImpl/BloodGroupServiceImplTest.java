package com.in.ServiceImpl;

import com.in.Entity.BloodGroup;
import com.in.Repository.BloodGroupRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BloodGroupServiceImplTest {

@Mock
private BloodGroupRepository bloodGroupRepository;

@InjectMocks
private BloodGroupServiceImpl bloodGroupService;

private static BloodGroup bloodGroup;


    @BeforeEach
    void setUp() {
        bloodGroup = BloodGroup.builder()
                .bloodgroupid(1)
                .bloodgroup("R")
                .build();

    }

    @AfterEach
    void tearDown() throws Exception{

    }

    @Test
    void saveBlood() {
       // given
        given(bloodGroupRepository.save(bloodGroup)).willReturn(bloodGroup);

        // when -  action or the behaviour that we are going test
        BloodGroup savedblood = bloodGroupService.saveBlood(bloodGroup);
        // then - verify the output
        assertThat(savedblood).isNotNull();
        assertEquals(savedblood,bloodGroup);
    }

    @Test
    void getAllBloodGroups() {

        List<String> list1=new ArrayList<>();
        list1.add("A+");
        list1.add("B+");
        when(bloodGroupRepository.getAllBloodGroups_json()).thenReturn(list1);

        List<String> savedblood = bloodGroupService.getAllBloodGroups();
        assertThat(savedblood).isEqualTo(list1);

    }

    @Test
    void addBloodGroup() {
       given(bloodGroupRepository.findByBloodgroup("R")).willReturn(bloodGroup);
       BloodGroup bloodGroup1=bloodGroupService.addBloodGroup("R");
       assertThat(bloodGroup1).isNotNull();

    }

    @Test
    void addBloodGroup_1() {
        given(bloodGroupRepository.save(bloodGroup)).willReturn(bloodGroup);
        bloodGroup.setBloodgroup("q");

        // when -  action or the behaviour that we are going test
        BloodGroup savedblood = bloodGroupService.addBloodGroup(bloodGroup.getBloodgroup());
        // then - verify the output
        assertThat(savedblood).isNotNull();
        assertEquals(savedblood,bloodGroup);
    }


    @Test
    void getAllBloodGroup() {
        BloodGroup bloodgroup1=new BloodGroup(1,"A+");
        BloodGroup bloodgroup2=new BloodGroup(2,"B+");
        List<BloodGroup> Expected_list=new ArrayList<>();
        Expected_list.add(bloodgroup1);
        Expected_list.add(bloodgroup2);

        given(bloodGroupRepository.findAll()).willReturn(Expected_list);

        List<BloodGroup> actual_list=bloodGroupService.getAllBloodGroup_json();

        assertThat(actual_list).isEqualTo(Expected_list);

    }


}