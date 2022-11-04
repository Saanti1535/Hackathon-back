package com.majorkeytech.hackaton.service;

import com.majorkeytech.hackaton.businessExceptions.DataConsistencyException;
import com.majorkeytech.hackaton.model.User;
import com.majorkeytech.hackaton.repository.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final String BASE_ERROR_MSG = "You must specify a non-void and valid ";
	private static final String EMAIL_ERROR_MSG = BASE_ERROR_MSG + "email. PS: You need a @majorkeytech email.";
	private static final String FIRSTNAME_ERROR_MSG = BASE_ERROR_MSG + "firstname.";
	private static final String LASTNAME_ERROR_MSG = BASE_ERROR_MSG + "lastname.";
	private static final String PASSWORD_ERROR_MSG = BASE_ERROR_MSG + "password.";
	
	private static final String MAIL_REGISTERED_ERROR_MSG = "The provided email is already in use.";
	
	private static final String MK_DOMAIN = "MAJORKEYTECH.COM";
	
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public void saveUser(User user) {
    	validateRegitration(user);
    	validateData(user);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    
    public void login(String email, String password) {
    	password = encoder.encode(password);
    	if(!userRepository.existsByEmailAndPassword(email, password)) {
    		throw new SecurityException("Incorrect email or password");
    	};
    }
    
    public void update(User user) {
    	validateRegitration(user);
    	validateData(user);
    	User old = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
    	user.setPassword(old.getPassword());
    	userRepository.save(user);
    }

	private void validateData(User user) {
		if(StringUtils.isBlank(user.getEmail()) || user.getEmail().toUpperCase().indexOf(MK_DOMAIN) == -1) {
			throw new DataConsistencyException(EMAIL_ERROR_MSG);
		}
		if(StringUtils.isBlank(user.getFirstName())) {
			throw new DataConsistencyException(FIRSTNAME_ERROR_MSG);
		}
		if(StringUtils.isBlank(user.getLastName())) {
			throw new DataConsistencyException(LASTNAME_ERROR_MSG);
		}
		if(StringUtils.isBlank(user.getPassword())) {
			throw new DataConsistencyException(PASSWORD_ERROR_MSG);
		}
	}
	
	private void validateRegitration(User user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new DataConsistencyException(MAIL_REGISTERED_ERROR_MSG);
		}
	}
}
