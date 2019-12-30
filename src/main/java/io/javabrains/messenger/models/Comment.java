package io.javabrains.messenger.models;

import java.util.Date;

public class Comment {

	private long id;
	private Date created;
	private String author;
	private String comment;
	
	public Comment () {
	}
	
	public Comment(long id, String author, String comment) {
		this.id = id;
		this.author = author;
		this.comment = comment;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	public String getAuthor() {
		return author;
	}
	public Date getCreated() {
		return created;
	}
	public String getComment() {
		return comment;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setAuthor (String author) {
		this.author = author;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
