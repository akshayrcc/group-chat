package com.udacity.mvc.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.mvc.mapper.UserMapper;
import com.udacity.mvc.model.User;

@Service
public class UserService {

	@Autowired
    private UserMapper userMapper;
	@Autowired
	private HashService hashService;

//    public UserService(UserMapper userMapper, HashService hashService) {
//        this.userMapper = userMapper;
//        this.hashService = hashService;
//    }

    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;
    }

    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.insert(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName()));
    }

    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
