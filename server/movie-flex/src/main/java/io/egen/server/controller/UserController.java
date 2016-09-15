package io.egen.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.server.entity.User;
import io.egen.server.service.UserSrevice;

@RestController
@RequestMapping (value ="user")
public class UserController {

	@Autowired
	UserSrevice service;

	@RequestMapping(method = RequestMethod.POST, value = "registration", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@RequestMapping (method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser(@RequestBody User user, @PathVariable("id") String id ) {
		
		return service.updateUser(user,id);
		
	}
	
	@RequestMapping (method = RequestMethod.POST, value = "auth/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean userAuthentication (@RequestBody User user, @PathVariable("id") String id ) {
		return service.userAuthentication (user, id);
	}
	
	@RequestMapping (method = RequestMethod.DELETE, value = "{id}") 
		public  String deleteUser(@PathVariable("id") String id) {
			return service.deleteUser(id);
		
	}
	
}


