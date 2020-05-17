package com.cdac.evillagers.master.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ER_Reply")
public class Reply {
	@Id
	@GeneratedValue
	private int id;
	private String content;
	private String forwardto;
	private int complaintId;
	private LocalDateTime dateOfReply;
	private String forwardfrom;
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
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public LocalDateTime getDateOfReply() {
		return dateOfReply;
	}
	public void setDateOfReply(LocalDateTime dateOfReply) {
		this.dateOfReply = dateOfReply;
	}
	public String getForwardfrom() {
		return forwardfrom;
	}
	public void setForwardfrom(String forwardfrom) {
		this.forwardfrom = forwardfrom;
	}
	

}
