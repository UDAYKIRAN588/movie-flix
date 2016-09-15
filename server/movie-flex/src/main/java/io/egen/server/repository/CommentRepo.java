package io.egen.server.repository;

import io.egen.server.entity.Comment;

public interface CommentRepo {


	void deleteComment(Comment existing);

	void updateComment(Comment comment, String imdbId, String userId);

	Comment getCommet(String data_id);

	Comment findOne(String id);

	void postComment(Comment comment, String imdbId, String userId);

}
