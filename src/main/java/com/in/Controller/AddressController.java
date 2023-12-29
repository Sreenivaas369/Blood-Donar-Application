package com.in.Controller;

import com.in.Entity.Address;
import com.in.Service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AddressController {

    @Autowired
    private AddressService aService;


    @GetMapping("/getCountryList")
    public ResponseEntity<List<String>> getCountryList() {
        return new ResponseEntity<>(aService.getCountryList(), HttpStatus.OK);

    }

    @GetMapping("/getStateList")
    public ResponseEntity<List<String>> getStateList(@RequestParam String country) {
        return new ResponseEntity<>(aService.getStateList(country), HttpStatus.OK);
    }

    @GetMapping("/getDistrictList")
    public ResponseEntity<List<String>> getDistrictList(@RequestParam String state) {
        return new ResponseEntity<>(aService.getDistrictList(state), HttpStatus.OK);

    }

    @GetMapping("/getCityList")
    public ResponseEntity<List<String>> getCityList(@RequestParam String district) {
        return new ResponseEntity<>(aService.getCityList(district), HttpStatus.OK);

    }


// Extra code

    @PostMapping("/saveAddress")
    public ResponseEntity<Address> SaveAddress(@Valid @RequestBody Address address) {
        Address checkaddress = aService.findByCity(address.getCity());
        if (checkaddress != null) {
            return new ResponseEntity<>(checkaddress, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(aService.saveAddress(address), HttpStatus.OK);

    }

}
