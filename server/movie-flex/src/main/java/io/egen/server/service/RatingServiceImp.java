package io.egen.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.server.entity.Comment;
import io.egen.server.entity.Rating;
import io.egen.server.exception.EntityNotFoundException;
import io.egen.server.repository.RatingRepo;


@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	RatingRepo repo;
	
	@Transactional
	@Override
	public Rating postRating(Rating rating, String movie_id, String user_id) {
		
		
		return repo.postRating(rating,movie_id,user_id);
	}


	@Override
	public Rating getRating(String data_id) {
		return repo.getRating(data_id);
	}

	@Transactional
	@Override
	public Rating updateRating(Rating rating, String imdbId, String userId) {
		
		Rating existing = repo.findOne(rating.getRating_id());
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		existing.setRating(rating.getRating());
		existing.setReview(rating.getReview());
		return repo.updateRating(existing,imdbId,userId);
	}

}
