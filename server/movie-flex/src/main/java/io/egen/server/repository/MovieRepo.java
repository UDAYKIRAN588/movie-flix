package io.egen.server.repository;

import java.util.List;
import java.util.Map;

import io.egen.server.entity.Imdb;

public interface MovieRepo {

	public void loadData();

	public List<Imdb> getType(String type);

	public List<Imdb> getAll(String type);

	public List<Imdb> dataExists(Imdb imdb);

	public void addData(Imdb imdb);
	
	public Imdb findOne(String id);

	public List<Imdb>findByParameters(Map<String, String> params);

}
