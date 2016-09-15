package io.egen.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.server.entity.Comment;
import io.egen.server.service.CommentService;


@RestController
@RequestMapping(value="comments")
public class CommentController {  
	
	@Autowired
	CommentService commentServ;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment postComment(@RequestBody Comment comment,@RequestParam("imdbId") String imdbId,@RequestParam("userId") String userId) {
		return commentServ.postComment(comment,imdbId,userId);
				
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
	public void deleteComment(@PathVariable("id") String id) {
		commentServ.deleteComment(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment updatComment (@RequestBody Comment comment, @RequestParam("imdbId") String imdbId, @RequestParam("userId") String userId) {
		return commentServ.updateComment(comment,imdbId,userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getComment (@RequestParam("movieid") String data_id) {
		return data_id;        
	}

}  
