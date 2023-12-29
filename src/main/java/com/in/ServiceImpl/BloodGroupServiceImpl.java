package com.in.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in.Entity.BloodGroup;
import com.in.Repository.BloodGroupRepository;
import com.in.Service.BloodGroupService;


@Service
public class BloodGroupServiceImpl implements BloodGroupService {

    @Autowired
    private BloodGroupRepository bRepo;

    public BloodGroup saveBlood(BloodGroup bloodgroup) {
        BloodGroup checkblood = bRepo.findByBloodgroup(bloodgroup.getBloodgroup());
        if (checkblood != null) {
            return checkblood;
        }
        return bRepo.save(bloodgroup);
    }

    public List<String> getAllBloodGroups() {
        return bRepo.getAllBloodGroups_json();
    }


    // For Registration

    public BloodGroup addBloodGroup(String bloodgroup) {
        BloodGroup bloodGroup = new BloodGroup();
        BloodGroup checkblood = bRepo.findByBloodgroup(bloodgroup);
        if (checkblood != null) {
            return checkblood;
        }
        bloodGroup.setBloodgroup(bloodgroup);
        return bRepo.save(bloodGroup);
    }

//Extra Code

    public List<BloodGroup> getAllBloodGroup_json() {
        return bRepo.findAll();
    }


}
