package io.egen.server.service;


import io.egen.server.entity.User;


public interface UserSrevice {
	

	public User createUser(User user);

	public User updateUser(User user, String id);

	public boolean userAuthentication(User user, String id);

	public String deleteUser(String id);


}
