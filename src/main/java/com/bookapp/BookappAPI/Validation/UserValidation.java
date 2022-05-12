package com.bookapp.bookappapi.Validation;

import org.springframework.stereotype.Component;

import com.bookapp.bookappapi.model.User;

@Component
public class UserValidation {

	public static void validateUser(User user) throws Exception{
		
		if(user.getName()==null||user.getName().contains("@")) {
			throw new Exception("invalid username!.Enter a valid username");
		}
		
		if(user.getEmail()==null||!user.getEmail().contains("@")||!user.getEmail().contains(".com")) {
			throw new Exception("invalid email.! Enter a valid email address");
		}
		
		
		if(user.getPassword()==null||user.getPassword().length()<=8) {
			throw new Exception("enter a valid password");
		}
		
		if(user.getMobileNumber()==null) {
			throw new Exception("enter a valid mobileNumber");
		}
	}
		public static void validateLogin(User userLogin) throws Exception {
			if (userLogin.getEmail() == null || userLogin.getEmail().trim().equals("")) {
				throw new Exception ("Invalid email");
			} else if (!userLogin.getEmail().contains("@")) {
				throw new Exception ("Email should contain @");
			}
			if (userLogin.getPassword() == null || userLogin.getPassword().trim().equals("")) {
				throw new Exception ("Invalid password");
			} else if (userLogin.getPassword().length() < 8) {
				throw new Exception ("Password must be minimum 8 characters");
			}
		}

		
	
		
			
	}

		
		
	

