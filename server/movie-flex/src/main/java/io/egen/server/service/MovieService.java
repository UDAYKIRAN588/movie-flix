package io.egen.server.service;

import java.util.List;
import java.util.Map;

import io.egen.server.entity.Imdb;

public interface MovieService {

	public List<Imdb> findALL();

	public void loadData();

	public List<Imdb> getAll(String type);

	public void addData(Imdb imdb);

	public List<Imdb> findByParameters(Map<String, String> params);


}
