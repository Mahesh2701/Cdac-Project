package com.cdac.evillagers.master.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ER_Reply")
public class Reply {
	@Id
	@GeneratedValue
	private int id;
	private String content;
	private String forwardto;
	private int postID;
	private LocalDateTime dateOfReply;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getForwardto() {
		return forwardto;
	}
	public void setForwardto(String forwardto) {
		this.forwardto = forwardto;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public LocalDateTime getDateOfReply() {
		return dateOfReply;
	}
	public void setDateOfReply(LocalDateTime dateOfReply) {
		this.dateOfReply = dateOfReply;
	}
	
}
