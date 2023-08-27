package com.Goldilocks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Goldilocks.Entity.User;
import com.Goldilocks.Exception.UserCridentialException;
import com.Goldilocks.Repository.UserRepository;

@Service
public class UserImpl implements UserInterface{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public String registerUser(User user) throws UserCridentialException {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if(existingUser != null) throw new UserCridentialException("User Already Registered with user name");
		
		userRepository.save(existingUser);
		return "User has been successfully Registered"; 
	}

	@Override
	public String loginUser(User user) throws UserCridentialException {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if(existingUser != null) {
			if(existingUser.getPassword().equals(user.getPassword())) return "Welcom "+existingUser.getUsername();
			throw new UserCridentialException("Password Invalid");
		}
		throw new UserCridentialException("User not found");
	}

}
