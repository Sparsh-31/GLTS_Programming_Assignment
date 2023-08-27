package com.Goldilocks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Goldilocks.Entity.User;
import com.Goldilocks.Service.UserInterface;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	UserInterface userInterface;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user)throws Exception{
		
		String result = userInterface.registerUser(user);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody User user)throws Exception{
		
		String result = userInterface.registerUser(user);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
