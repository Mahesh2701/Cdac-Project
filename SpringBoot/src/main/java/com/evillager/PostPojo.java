package com.evillager;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ER_Post")
public class PostPojo {

	@Id
	@GeneratedValue
	private int complaintId;
	private String name;
	private Blob image;
	private String message;
	private LocalDateTime dateline;
	private String dept;
	private String statuslevel;

	public String getStatuslevel() {
		return statuslevel;
	}

	public void setStatuslevel(String statuslevel) {
		this.statuslevel = statuslevel;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateline() {
		return dateline;
	}

	public void setDateline(LocalDateTime localDateTime) {
		this.dateline = localDateTime;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
