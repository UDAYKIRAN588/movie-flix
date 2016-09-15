package io.egen.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.server.entity.User;

@Repository
public class UserRepoImp implements UserRepo {
	
	@PersistenceContext
	EntityManager manager;

	
	@Override
	public User createUser(User user) {
		manager.persist(user);
		return user;
	}

	@Override
	public User checkEmail(String email) {
		TypedQuery<User> query = manager.createNamedQuery("User.email", User.class);
		query.setParameter("pEmail", email);
		try { 
		return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User updateUser(User user, String id) {
		return manager.merge(user);
	}

	@Override
	public User findOne(String id) {
		return manager.find(User.class, id);
	}

	@Override
	public boolean userAuthentication(User user) {

		TypedQuery<User> tq = manager.createNamedQuery("User.authenticate", User.class);
	    tq.setParameter("pEmail",user.getEmail());
	    tq.setParameter("pPasswd",user.getPasswd());
	    tq.setParameter("pType",user.getType());
	    User u = tq.getSingleResult();
	    if (u == null)
	    {
	    	return false;
	    } else {
	    	return true;
	    }
	}

	@Override
	public String deleteUser(String id) {
		manager.remove(findOne(id));
		return"deleted" ;
	}
	

}
