package io.egen.server.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.egen.server.entity.Imdb;
import io.egen.server.util.Data;

@Repository
public class MovieRepoImp implements MovieRepo {
	
	public final String QUERY_END_POINT="SELECT m FROM Imdb m ";
	
	@PersistenceContext
	EntityManager manager;
	

	@Transactional
	@Override
	public void loadData()  {
		

		ObjectMapper mapper = new ObjectMapper();
		Data obj = null;
		
		try {
			obj = mapper.readValue(new File("/Users/dlrl/Desktop/data.json"),Data.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Imdb dm: obj.getData()){
		manager.persist(dm);
		}
	}
	
	@Transactional
	@Override
	public List<Imdb> getType(String type) {
		
		TypedQuery<Imdb> tq = manager.createNamedQuery("Imdb.type", Imdb.class);
		tq.setParameter("pType",type);
		return tq.getResultList();
	}

	@Override
	public List<Imdb> getAll(String type) {
		
		TypedQuery<Imdb> tq = manager.createNamedQuery("Imdb.getAll", Imdb.class);
		return tq.getResultList();
		
	}
	
	@Override
	public List<Imdb> dataExists(Imdb imdb) {
		
			TypedQuery<Imdb> tq = manager.createNamedQuery("Imdb.test", Imdb.class);
		    tq.setParameter("pTitle",imdb.getTitle());
		    tq.setParameter("pType",imdb.getType());
		    return tq.getResultList();
		
	}

	@Override
	public void addData(Imdb imdb) {
		manager.persist(imdb);
	}

	@Override
	public Imdb findOne(String id) {
		return manager.find(Imdb.class, id);
	}
	
	@Override
	public List<Imdb> findByParameters(Map<String, String> params) {
		
		String query = buildQuery(params);
		TypedQuery<Imdb> tquery =  manager.createQuery(query,Imdb.class).
				setFirstResult(Integer.parseInt(params.get("start"))).
				setMaxResults(Integer.parseInt(params.get("offset")));
		if (query.contains(":gen")){
		tquery.setParameter("gen",  "%" + params.get("genre") + "%");}
		return tquery.getResultList();
		
	}

	private String buildQuery(Map<String, String> params) {
		String query = QUERY_END_POINT;
		String filter = getFilter(params);
		String sort = getSort(params);
		if (filter != null) {
			query= query + " where "+filter;
		}
		if (sort !=null){
			query = query+sort;
		}
		if (params.get("start") == null|| params.get("offset") == null)
		{
			params.put("start", "0");
			params.put("offset", "100");
		}
	
		return query;
	}

	private String getSort(Map<String, String> params) {
		// IMDBRating year votes
		String temp = params.get("sort");
		
		if (temp !=null) {
		if (temp.equals("year")){
			return " ORDER BY m.year"; 
		} else if (temp.equals("rating"))  {
			return " ORDER BY m.imdbRating"; 
		} else if (temp.equals("votes"))  {
			return " ORDER BY m.imdbVotes"; 
		}
		}
		return null;
		
	}

	private String getFilter(Map<String, String> params) {
		String temp =null;
		
		if ((temp=params.get("type"))!=null){
			return "m.type="+temp; 
		} else if ((temp=params.get("year"))!=null)  {
			return "m.year="+temp; 
		} else if ((temp=params.get("genre"))!=null)  {
			return "m.genre Like :gen"; 
		}
		return null;
	}
	  
	
//	public List<Imdb> test(Imdb imdb) {   
//		
//	
//	    
//	   
//	
//	return tq.getResultList();
//	}
//		

	//DataExists
//	TypedQuery<Imdb> tq = manager.createNamedQuery("Imdb.dataExists", Imdb.class);
//	tq.setParameter("pTitle",imdb.getTitle());
//	tq.setParameter("pType",imdb.getType());
//	
//	

	
	

	

}
