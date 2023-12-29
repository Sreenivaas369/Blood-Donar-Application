//package com.in.general;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.reset;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.internal.verification.VerificationModeFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.in.Controller.AddressController;
//import com.in.Entity.BloodGroup;
//import com.in.Service.BloodGroupService;
//
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = AddressController.class)
//public class BloodGroupControllerTests {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private BloodGroupService service;
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @Test
//    public void whenPostEmployee_thenCreateEmployee() throws Exception {
//    	BloodGroup alex = new BloodGroup("alex");
//        given(service.save(Mockito.any())).willReturn(alex);
////
////        mvc.perform(post("/AddBloodGroup").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(alex))).andExpect(status().isCreated()).andExpect(jsonPath("$.bloodgroup", is("alex")));
////        verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
////        reset(service);
//    }
//
//    @Test
//    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
//        BloodGroup alex = new BloodGroup("Q");
//        BloodGroup john = new BloodGroup("W");
//        BloodGroup bob = new BloodGroup("P");
//
//        List<BloodGroup> allEmployees = Arrays.asList(alex, john, bob);
//
//        given(service.getAllBloodGroups()).willReturn(allEmployees);
//
////        mvc.perform(get("/GetBloodGroups").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].bloodgroup", is(alex.getBloodgroup()))).andExpect(jsonPath("$[1].bloodgroup", is(john.getBloodgroup())))
////                .andExpect(jsonPath("$[2].name", is(bob.getBloodgroup())));
////        verify(service, VerificationModeFactory.times(1)).getAllBloodGroups();
////        reset(service);
//    }
//
//}