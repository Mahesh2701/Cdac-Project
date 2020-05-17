package com.evillager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class VillageController {

	@Autowired
	private VillagerRepository villagerRepository;

	@PostMapping("/registration")
	public void register(@RequestBody UserRegistration userRegistration) {

		System.out.println("in registration");
		villagerRepository.reg(userRegistration);

	}

	@PostMapping("/login")
	public Status login(@RequestBody UserRegistration userRegistration) {
		long count = villagerRepository.isValidUser(userRegistration.getUsername(), userRegistration.getPassword());

		if (count == 0) {
			Status status = new Status();
			status.setStatusCode(222);
			status.setStatusMessage("Invalid Username/Password");
			return status;
		} else {
			UserRegistration customer = villagerRepository.fetch(userRegistration.getUsername());

			Status status = new Status();
			status.setStatusCode(333);
			status.setStatusMessage("Login Successful");
			status.setLoggedInCustomer(customer);
			return status;
		}

	}

	@PostMapping("/post")
	public void post(@RequestBody PostPojo p) {

		villagerRepository.postSave(p);

	}

	public static class Status {
		
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
}
