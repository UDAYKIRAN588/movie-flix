package io.egen.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.server.entity.Rating;
import io.egen.server.service.RatingService;

@RestController
@RequestMapping(value = "ratings")
public class RatingControler {
	
	@Autowired
	RatingService service;
	
	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating postRating(@RequestBody Rating rating,@RequestParam("imdbId") String imdbId,@RequestParam("userId") String userId) {
		return service.postRating(rating,imdbId,userId);
				
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating updatRating (@RequestBody Rating rating,@RequestParam("imdbId") String imdbId,@RequestParam("userId") String userId) {
		return service.updateRating(rating,imdbId,userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getRating (@RequestParam("movieId") String data_id) {
		service.getRating(data_id);
		return data_id;        
	}


}
