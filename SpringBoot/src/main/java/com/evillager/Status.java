package com.evillager;

public class Status {
	
	private int statusCode;
	private String statusMessage;
	private UserRegistration loggedInCustomer;

	public UserRegistration getLoggedInCustomer() {
		return loggedInCustomer;
	}

	public void setLoggedInCustomer(UserRegistration loggedInCustomer) {
		this.loggedInCustomer = loggedInCustomer;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
