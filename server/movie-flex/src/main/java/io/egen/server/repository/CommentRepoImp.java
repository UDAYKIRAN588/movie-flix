package io.egen.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.egen.server.entity.Comment;

@Repository


public class CommentRepoImp implements CommentRepo{
	
	
	@PersistenceContext
	EntityManager manager;
	@Autowired
	MovieRepo movie;
	@Autowired
	UserRepo user;
	
	@Override
	public void postComment(Comment comment, String imdbId, String userId) {
		
		comment.setData(movie.findOne(imdbId));
		comment.setUser(user.findOne(userId));
		manager.persist(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		manager.remove(comment);
		
	}

	@Override
	public void updateComment(Comment comment, String imdbId,String userId) {

		//comment.setComment("uday kiarn");
		manager.merge(comment);
	}

	@Override
	public Comment getCommet(String data_id) {
		return findOne(data_id);
	}

	@Override
	public Comment findOne(String id) {
		// TODO Auto-generated method stub
		return  manager.find(Comment.class, id);
	}

}
