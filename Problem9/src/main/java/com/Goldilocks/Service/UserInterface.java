package com.Goldilocks.Service;

import com.Goldilocks.Entity.User;
import com.Goldilocks.Exception.UserCridentialException;

public interface UserInterface {
	
	public String registerUser(User user) throws UserCridentialException;
	public String loginUser(User user) throws UserCridentialException;
	
}
