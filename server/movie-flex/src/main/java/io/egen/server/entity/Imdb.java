	package io.egen.server.entity;


import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"Title",
"Year",
"Rated",
"Released",
"Runtime",
"Genre",
"Director",
"Writer",
"Actors",
"Plot",
"Language",
"Country",
"Awards",
"Poster",
"Metascore",
"imdbRating",
"imdbVotes",
"imdbID",
"Type"
})
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"type","title"}))
@NamedQueries({@NamedQuery(name = "Imdb.getAll", query = "SELECT d  from Imdb d"),
	@NamedQuery(name = "Imdb.FindByRating", query = "SELECT d  from Imdb d where d.imdbRating=:pRating"),
	@NamedQuery(name = "Imdb.type", query = "SELECT d from Imdb d where d.type = :pType"),
	@NamedQuery(name = "Imdb.dataExists", query = "SELECT d from Imdb d where d.type = :pType AND d.title = :pTitle"),
	@NamedQuery(name = "Imdb.test", query = "SELECT d from Imdb d where  d.title = :pTitle and d.type =:pType")})
public class Imdb {

@Id	
private String id;
@JsonProperty("Title")
@Column(name="title")
private String title;
@JsonProperty("Year")
private Integer year;
@JsonProperty("Rated")
private String rated;
@JsonProperty("Released")
private String released;
@JsonProperty("Runtime")
private String runtime;
@JsonProperty("Genre")
private String genre;
@JsonProperty("Director")
private String director;
@Column(length= 4000) 
@JsonProperty("Writer")
private String writer;
@JsonProperty("Actors")
private String actors;
@JsonProperty("Plot")
@Column(length= 4000) 
private String plot;
@JsonProperty("Language")
private String language;
@JsonProperty("Country")
private String country;
@JsonProperty("Awards")
private String awards;
@JsonProperty("Poster")
private String poster;
@JsonProperty("Metascore")
private Integer metascore;
@JsonProperty("imdbRating")
private Integer imdbRating;
@JsonProperty("imdbVotes")
private Integer imdbVotes;
@JsonProperty("imdbID")
private String imdbID;
@JsonProperty("Type")
@Column(name="type")
private String type;



public Imdb () {
	this.id = UUID.randomUUID().toString();
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = UUID.randomUUID().toString();
}

/**      
* 
* @return
* The title
*/
@JsonProperty("Title")
public String getTitle() {          
return title;
}

/**
* 
* @param title
* The Title
*/
@JsonProperty("Title")
public void setTitle(String title) {
this.title = title;
}

/**
* 
* @return
* The year
*/
@JsonProperty("Year")
public Integer getYear() {
return year;
}

/**
* 
* @param year
* The Year
*/
@JsonProperty("Year")
public void setYear(Integer year) {
this.year = year;
}

/**
* 
* @return
* The rated
*/
@JsonProperty("Rated")
public String getRated() {
return rated;
}

/**
* 
* @param rated
* The Rated
*/
@JsonProperty("Rated")
public void setRated(String rated) {
this.rated = rated;
}

/**
* 
* @return
* The released
*/
@JsonProperty("Released")
public String getReleased() {
return released;
}

/**
* 
* @param released
* The Released
*/
@JsonProperty("Released")
public void setReleased(String released) {
this.released = released;
}

/**
* 
* @return
* The runtime
*/
@JsonProperty("Runtime")
public String getRuntime() {
return runtime;
}

/**
* 
* @param runtime
* The Runtime
*/
@JsonProperty("Runtime")
public void setRuntime(String runtime) {
this.runtime = runtime;
}

/**
* 
* @return
* The genre
*/
@JsonProperty("Genre")
public String getGenre() {
return genre;
}

/**
* 
* @param genre
* The Genre
*/
@JsonProperty("Genre")
public void setGenre(String genre) {
this.genre = genre;
}

/**
* 
* @return
* The director
*/
@JsonProperty("Director")
public String getDirector() {
return director;
}

/**
* 
* @param director
* The Director
*/
@JsonProperty("Director")
public void setDirector(String director) {
this.director = director;
}

/**
* 
* @return
* The writer
*/
@JsonProperty("Writer")
public String getWriter() {
return writer;
}

/**
* 
* @param writer
* The Writer
*/
@JsonProperty("Writer")
public void setWriter(String writer) {
this.writer = writer;
}

/**
* 
* @return
* The actors
*/
@JsonProperty("Actors")
public String getActors() {
return actors;
}

/**
* 
* @param actors
* The Actors
*/
@JsonProperty("Actors")
public void setActors(String actors) {
this.actors = actors;
}

/**
* 
* @return
* The plot
*/
@JsonProperty("Plot")
public String getPlot() {
return plot;
}

/**
* 
* @param plot
* The Plot
*/
@JsonProperty("Plot")
public void setPlot(String plot) {
this.plot = plot;
}

/**
* 
* @return
* The language
*/
@JsonProperty("Language")
public String getLanguage() {
return language;
}

/**
* 
* @param language
* The Language
*/
@JsonProperty("Language")
public void setLanguage(String language) {
this.language = language;
}

/**
* 
* @return
* The country
*/
@JsonProperty("Country")
public String getCountry() {
return country;
}

/**
* 
* @param country
* The Country
*/
@JsonProperty("Country")
public void setCountry(String country) {
this.country = country;
}

/**
* 
* @return
* The awards
*/
@JsonProperty("Awards")
public String getAwards() {
return awards;
}

/**
* 
* @param awards
* The Awards
*/
@JsonProperty("Awards")
public void setAwards(String awards) {
this.awards = awards;
}

/**
* 
* @return
* The poster
*/
@JsonProperty("Poster")
public String getPoster() {
return poster;
}

/**
* 
* @param poster
* The Poster
*/
@JsonProperty("Poster")
public void setPoster(String poster) {
this.poster = poster;
}

/**
* 
* @return
* The metascore
*/
@JsonProperty("Metascore")
public Integer getMetascore() {
return metascore;
}

/**
* 
* @param metascore
* The Metascore
*/
@JsonProperty("Metascore")
public void setMetascore(Integer metascore) {
this.metascore = metascore;
}

/**
* 
* @return
* The imdbRating
*/
@JsonProperty("imdbRating")
public Integer getImdbRating() {
return imdbRating;
}

/**
* 
* @param imdbRating
* The imdbRating
*/
@JsonProperty("imdbRating")
public void setImdbRating(Integer imdbRating) {
this.imdbRating = imdbRating;
}

/**
* 
* @return
* The imdbVotes
*/
@JsonProperty("imdbVotes")
public Integer getImdbVotes() {
return imdbVotes;
}

/**
* 
* @param imdbVotes
* The imdbVotes
*/
@JsonProperty("imdbVotes")
public void setImdbVotes(Integer imdbVotes) {
this.imdbVotes = imdbVotes;
}

/**
* 
* @return
* The imdbID
*/
@JsonProperty("imdbID")
public String getImdbID() {
return imdbID;
}

/**
* 
* @param imdbID
* The imdbID
*/
@JsonProperty("imdbID")
public void setImdbID(String imdbID) {
this.imdbID = imdbID;
}

/**
* 
* @return
* The type
*/
@JsonProperty("Type")
public String getType() {
return type;
}

/**
* 
* @param type
* The Type
*/
@JsonProperty("Type")
public void setType(String type) {
this.type = type;
}


@Override
public String toString() {
	return "Imdb [title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released + ", runtime="
			+ runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer + ", actors=" + actors
			+ ", plot=" + plot + ", language=" + language + ", country=" + country + ", awards=" + awards + ", poster="
			+ poster + ", metascore=" + metascore + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes
			+ ", imdbID=" + imdbID + ", type=" + type +"]";
}


}

