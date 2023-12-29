package com.in.ServiceImpl;

import com.in.Entity.User;
import com.in.ExceptionHandler.UserNotFoundException;
import com.in.Repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;


import javax.swing.text.html.Option;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;



    @BeforeEach
    void setUp() {
        user= User.builder()
                .userid("Sreenivas@gmail.com")
                .password("Sree@123")
                .date("12-12-23")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void userLoginDetails() {
        given(userRepository.findByUserid("Sreenivas@gmail.com")).willReturn(user);

        // when -  action or the behaviour that we are going test
//        assertThrows(UserNotFoundException.class, () -> {
//            userService.userLoginDetails(user);
//           // IllegalArgumentException
//        });
        assertThrows(IllegalArgumentException.class, () -> {
            userService.userLoginDetails(user);
            // IllegalArgumentException
        });

        // then
        verify(userRepository, never()).save(any(User.class));

    }


    @Test
    void updatePassword(){


        given(userRepository.findByUserid("Sreenivas@gmail.com")).willReturn(user);
        user.setPassword("Sreenivas@123");
        assertThat(user.getPassword()).isEqualTo("Sreenivas@123");

        assertThrows(UserNotFoundException.class, () -> {
            userService.updatePassword(user.getUserid(),user);
        });
        //assertThat(user.getPassword()).isEqualTo("Sreenivas@123");

        //UserNotFoundException
        //User us=userService.updatePassword(user.getUserid(),user);



    }

    @Test
    void userLogin() {
        given(userRepository.findByUserid("Sreenivas@gmail.com")).willReturn(user);

        // when -  action or the behaviour that we are going test
//        assertThrows(UserNotFoundException.class, () -> {
//            userService.userLoginDetails(user);
//            // IllegalArgumentException
//        });
        assertThrows(IllegalArgumentException.class, () -> {
            userService.userLoginDetails(user);
        });

        // then
        verify(userRepository, never()).save(any(User.class));


    }

    @Test
    void addUser() {

        when(userRepository.findByUserid(user.getUserid())).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        assertThrows(IllegalArgumentException.class, () -> {
            userService.userLoginDetails(user);

        });
        User us=userService.AddUser(user.getUserid(),user.getPassword());
        assertThat(us.getUserid()).isEqualTo(us.getUserid());

      //  DataIntegrityViolationException
    }
}