package io.egen.server.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"user_id","id"}))
public class Rating {
	
	@Id
	private String rating_id;
	private String review;

	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "id",nullable=false)
	private Imdb data;
	private Integer rating;
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Rating() {
		this.rating_id = UUID.randomUUID().toString();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Imdb getData() {
		return data;
	}

	public void setData(Imdb data) {
		this.data = data;
	}

	public String getRating_id() {
		return rating_id;
	}
	public void setRating_id(String rating_id) {
		this.rating_id = rating_id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	

}
