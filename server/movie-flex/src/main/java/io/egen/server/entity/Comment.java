package io.egen.server.entity;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({@NamedQuery(name="Comment.findById",query="SELECT c from Comment c where c.comment_id=:pId")})
public class Comment {
	
	@Id
	private String comment_id;
	private String comment;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Imdb data;
	@ManyToOne
	@JoinColumn(nullable=false)
	private User user;
	
	private Date date;
	
	public Imdb getData() {
		return data;
	}
	public void setData(Imdb data) {
		this.data = data;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Comment () {
		this.comment_id = UUID.randomUUID().toString();
	}
	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
