package io.egen.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.server.exception.EntityNotFoundException;
import io.egen.server.entity.Comment;
import io.egen.server.repository.CommentRepo;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	CommentRepo commentRep;

	@Transactional
	@Override
	public Comment postComment (Comment comment,String imdbId,String userId) {
		commentRep.postComment (comment, imdbId, userId);
		

		return null;
	}
	
	@Transactional
	@Override
	public void deleteComment(String id) {
		
		Comment existing = commentRep.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		commentRep.deleteComment(existing);
		
	}
	  
	@Transactional
	@Override
	public Comment updateComment(Comment comment, String imdbId, String userId) {
		Comment existing = commentRep.findOne(comment.getComment_id());
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		existing.setComment(comment.getComment());
		commentRep.updateComment(existing,imdbId,userId);

		return null;
	}

	@Override
	public Comment getCommet(String data_id) {
		

		return commentRep.getCommet(data_id);
	}


}
