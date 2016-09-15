package io.egen.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.egen.server.entity.Rating;


@Repository
public class RatingRepoImp implements RatingRepo {
	
	@PersistenceContext
	EntityManager manager;
	@Autowired
	MovieRepo movie;
	@Autowired
	UserRepo user;

	@Override
	public Rating postRating(Rating rating, String imdbId,String userId) {
		
		rating.setData(movie.findOne(imdbId));
		rating.setUser(user.findOne(userId));
		manager.persist(rating);
		return rating;
	}


	@Override
	public Rating getRating(String data_id) {
		return null;
	}

	@Override
	public Rating updateRating(Rating rating, String rating_id, String userId) {
		manager.merge(rating);
		return rating;
	}


	@Override
	public Rating findOne(String rating_id) {
		
		return manager.find(Rating.class,rating_id);
	}

}
