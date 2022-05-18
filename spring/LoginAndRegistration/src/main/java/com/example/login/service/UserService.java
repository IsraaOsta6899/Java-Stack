package com.example.login.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.login.models.LoginUser;
import com.example.login.models.User;
import com.example.login.repositories.UserRepository;
    

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

        // TO-DO: Additional validations!
    	Optional<User> user=userRepo.findByEmail(newUser.getEmail());

    	if(user.isEmpty()) {
    		User user2=newUser;
    		System.out.println("yaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	userRepo.save(newUser);
    	return newUser;
    	}
    	else {
    		ObjectError error=new ObjectError("inValid Email", "This email is already exist");
    		result.addError(error);
    		User user3=new User();
    		return user3;
    	}
        
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> user=userRepo.findByEmail(newLoginObject.getEmail());
    	if(user.isEmpty()) {
    		System.out.println("1111111111111111111111111111111111111111111111");

    		ObjectError error=new ObjectError("inValid Email", "This email is not exist");
    		return new User();

    	}
    	else {
    		System.out.println("8888888888888888888888888888888888888");

    		User user2= user.get();
    		if(!BCrypt.checkpw(newLoginObject.getPassword(), user2.getPassword())) {
        		System.out.println("777777777777777777777777777777777777777777");

    		    result.rejectValue("password", "Matches", "Invalid Password!");
    		    return new User();
    		}
    		else {
        		System.out.println("555555555555555555555");

				return user2;
			}
    	}

    }
}

