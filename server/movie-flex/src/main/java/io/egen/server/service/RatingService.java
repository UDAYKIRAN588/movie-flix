package io.egen.server.service;

import io.egen.server.entity.Rating;

public interface RatingService {

	public Rating postRating(Rating rating, String movie_id, String user_id);

	public Rating getRating(String data_id);

	public Rating updateRating(Rating rating, String imdbId, String userId);

}
