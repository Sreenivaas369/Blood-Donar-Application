package com.in.Controller;

import com.in.Entity.BloodGroup;
import com.in.ServiceImpl.BloodGroupServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BloodGroupControllerTest {

    @Mock
    private BloodGroupServiceImpl bloodGroupService;
    private BloodGroup bloodgroup;

    @InjectMocks
    private BloodGroupController bloodGroupController;

    @BeforeEach
    void setUp() {
        bloodgroup = BloodGroup
                .builder()
                .bloodgroupid(12)
                .bloodgroup("O+")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addBloodGroup() {
        // BloodGroup bloodGroup1=new BloodGroup(12,"A");
        when(bloodGroupService.saveBlood(bloodgroup)).thenReturn(bloodgroup);

        BloodGroup bloodGroup_1 = bloodGroupService.saveBlood(bloodgroup);
        assertThat(bloodGroup_1).isNotNull();

    }

    @Test
    void getAllBloodGroups() {
    }

    @Test
    void getAllBloodGroup() {
    }
}