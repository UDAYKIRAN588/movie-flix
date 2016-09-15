package io.egen.server.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.server.entity.Imdb;
import io.egen.server.exception.DataAlreadyExists;
import io.egen.server.exception.IllegalTypeException;
import io.egen.server.repository.MovieRepo;

@Service
public class MovieServiceImp implements MovieService{
	
	@Autowired
	MovieRepo repo;

	@Override
	public List<Imdb> findALL() {
		
		
		return null;
	}

	@Override
	public void loadData() {

		repo.loadData();
	}

	
	@Override
	public List<Imdb> getAll(String type) {
		
		if ((type.equals("movie")) || (type.equals("series"))) {
			return repo.getType(type);
		} else if ((type.equals("all")) || (type == null)) {
			return repo.getAll("all");
		}
		throw new IllegalTypeException("Unknown type expected type movie or series");
			
	}
	
	@Transactional
	@Override
	public void addData(Imdb imdb) {
		if (dataExists(imdb)) {
			
			throw new DataAlreadyExists("data already exists");
		} else {
		repo.addData(imdb);
		}
	}

	private boolean dataExists(Imdb imdb) {
		List<Imdb> data = repo.dataExists(imdb);
		if (data.size() > 0) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public List<Imdb> findByParameters(Map<String, String> params) {
		return repo.findByParameters(params);
	}

}
