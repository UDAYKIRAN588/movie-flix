package io.egen.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.server.entity.User;
import io.egen.server.repository.UserRepo;
import io.egen.server.exception.EntityNotFoundException;
import io.egen.server.exception.UserAlreadyExists;

@Service
public class UserServiceImp implements UserSrevice {

	@Autowired
	UserRepo userRepo;

	@Transactional
	@Override
	public User createUser(User user) {

		User u = userRepo.checkEmail(user.getEmail());
		if (u != null) {
			throw new UserAlreadyExists("This email is already registered");
		}
		return userRepo.createUser(user);
	}

	@Transactional
	@Override
	public User updateUser(User user, String id) {
		
		User existing = userRepo.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		
		return userRepo.updateUser(user, id);
	}
	
	@Override
	public boolean userAuthentication(User user, String id) {
		
		User existing = userRepo.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return userRepo.userAuthentication(user) ;
	}
	@Transactional
	@Override
	public String deleteUser(String id) {
		
		return userRepo.deleteUser(id);
	}

}
