package com.evillager;

import java.time.LocalDate;

import javax.imageio.stream.ImageInputStream;

public class Post
{
	private int id;
	private int complaintID;
	private ImageInputStream photo;
	private String content;
	private LocalDate dateOfPost;
	private int deadLine;
	private boolean hideme;
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}
	public ImageInputStream getPhoto() {
		return photo;
	}
	public void setPhoto(ImageInputStream photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getDateOfPost() {
		return dateOfPost;
	}
	public void setDateOfPost(LocalDate dateOfPost) {
		this.dateOfPost = dateOfPost;
	}
	public int getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}
	public boolean getHideme() {
		return hideme;
	}
	public void setHideme(boolean hideme) {
		this.hideme = hideme;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

