package com.evillager.Master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EV_Admin")
public class AdminControl {
	
	@Id
	@GeneratedValue
	private int id;
	private String adminName;
	private int previllageLevel;
	private String userName;
	private String password;
	private boolean status;

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getPrevillageLevel() {
		return previllageLevel;
	}
	public void setPrevillageLevel(int previllageLevel) {
		this.previllageLevel = previllageLevel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
