package io.egen.server.repository;

import io.egen.server.entity.Rating;

public interface RatingRepo {

	Rating postRating(Rating rating, String rating_id, String user_id);

	Rating updateRating(Rating rating, String rating_id, String userId);

	Rating getRating(String data_id);

	Rating findOne(String rating_id);

}
