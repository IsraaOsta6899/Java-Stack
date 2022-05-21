package com.example.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.bookclub.models.Book;
import com.example.bookclub.models.LoginUser;
import com.example.bookclub.models.User;
import com.example.bookclub.repositories.UserRepository;
    

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {

        // TO-DO: Additional validations!
    	Optional<User> user=userRepo.findByEmail(newUser.getEmail());

    	if(user.isEmpty()) {
    		User user2=newUser;
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
		    result.rejectValue("email", "invalidEmail", "Invalid email!");

    		return new User();

    	}
    	else {

    		User user2= user.get();
    		if(!BCrypt.checkpw(newLoginObject.getPassword(), user2.getPassword())) {

    		    result.rejectValue("password", "Matches", "Invalid Password!");
    		    return new User();
    		}
    		else {

				return user2;
			}
    	}

    }
    
    public User updateUser(User user) {
		return this.userRepo.save(user);
	}
}

