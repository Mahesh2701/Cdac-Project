package com.cdac.evillagers.master.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ER_Post")
public class PostPojo
{

	@Id
	@GeneratedValue
	private int complaintId;
	private String name;
	private Blob image;
	private String message;
	private Date dateline;
	private String Dept;

	public Date getDateline() {
		return dateline;
	}

	public void setDateline(Date dateline) {
		this.dateline = dateline;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
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

}
