package io.egen.server.repository;


import io.egen.server.entity.User;



public interface UserRepo {

	public User createUser(User user);

	public User checkEmail(String email);

	public User updateUser(User user, String id);

	public User findOne(String id);

	public boolean userAuthentication(User user);

	public String deleteUser(String id);

}
