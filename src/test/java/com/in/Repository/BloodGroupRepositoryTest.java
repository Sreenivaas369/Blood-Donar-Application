package com.in.Repository;

import com.in.Entity.BloodGroup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BloodGroupRepositoryTest {

  //given when then

    @Autowired
    private BloodGroupRepository bloodGroupRepository;
    BloodGroup bloodgroup;

    @BeforeEach
    public void SetUp(){
        bloodgroup=new BloodGroup(1,"Q");
        bloodGroupRepository.save(bloodgroup);
    }

    @AfterEach
    void tearDown() {
        bloodgroup=null;
        bloodGroupRepository.deleteAll();
    }
}
