package com.in.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.in.Entity.User;
import com.in.ExceptionHandler.UserNotFoundException;
import com.in.Repository.UserRepository;
import com.in.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uRepo;

	public String userLoginDetails(User user) throws UserNotFoundException {
		User checkuser = uRepo.findByUserid(user.getUserid());
		if (checkuser != null) {
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			log.info("pass {} and {}",user.getPassword(),checkuser.getPassword());
			log.info("id {} and {}",user.getUserid(),checkuser.getUserid());
			log.info("{}",bcrypt.matches(user.getPassword(), checkuser.getPassword()));
			if (bcrypt.matches(user.getPassword(), checkuser.getPassword())
					& checkuser.getUserid().equals(user.getUserid())) {
				return "Login Successfully";
			}
			else{
				throw new IllegalArgumentException("Username and password are incorrect");
			}

		}
		throw new UserNotFoundException("User not Registed, Please Register");


	}

	
	
	
	
	public String updatePassword(String userid, User user) throws UserNotFoundException {
		User checkuser = uRepo.findByUserid(userid);
		if (checkuser != null) {
			user.setUserid(userid);
			BCryptPasswordEncoder bcrypto = new BCryptPasswordEncoder();
			String bpass = bcrypto.encode(user.getPassword());
			user.setPassword(bpass);
			uRepo.save(user);
			return "Password saved Successfuly";
		}
		throw new UserNotFoundException("User Not Found");

	}

	public ResponseEntity<String> userLogin(String userid, String password) {
		User checkuser = uRepo.findByUserid(userid);
		if (checkuser != null) {
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			User user = uRepo.findByUserid(userid);
			String pass = user.getPassword();
			String username = user.getUserid();
			if (bcrypt.matches(password, pass) & userid.equals(username)) {
				return new ResponseEntity<>("Login Successfully", HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<>("Username and password are incorrect", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("Username and Password are incorrect or user not exist", HttpStatus.NOT_FOUND);
	}

	// For Registration

	public User AddUser(String userid, String password) {
		User checkuser = uRepo.findByUserid(userid);
		if (checkuser != null) {
			throw new DataIntegrityViolationException("User Already Registered ,Please Login");
		}
		User user = new User();
		BCryptPasswordEncoder bcrypto = new BCryptPasswordEncoder();
		String bpass = bcrypto.encode(password);
		user.setUserid(userid);
		user.setPassword(bpass);
		return uRepo.save(user);

	}

}
