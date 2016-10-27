package io.egen.server.service;

import io.egen.server.entity.Comment;


public interface CommentService {

	Comment postComment(Comment comment, String imdbId, String userId);

	void deleteComment(String id);

	Comment getCommet(String data_id);

	Comment updateComment(Comment comment, String imdbId, String userId);

}
