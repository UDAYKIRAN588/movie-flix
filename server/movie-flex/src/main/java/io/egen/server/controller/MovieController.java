package io.egen.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.server.entity.Imdb;
import io.egen.server.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired(required = false)
	MovieService movies;

	
//	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Imdb> getAll(@RequestParam(value = "type") String type,@RequestParam(value = "gener") String gener ) {
//		return movies.getAll(type); 
//		
//	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 	public List<Imdb> findAll(@RequestParam Map<String, String> params) {
		
		return movies.findByParameters(params) ;
 	}
	
	@RequestMapping(method = RequestMethod.GET, value = "loadData", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void loadData() {
		movies.loadData();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addData(@RequestBody Imdb imdb) {
		
		movies.addData(imdb);
	}
	
	

}
