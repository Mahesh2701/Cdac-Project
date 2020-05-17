package com.cdac.evillagers.master.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.evillagers.master.entity.PostPojo;
import com.cdac.evillagers.master.entity.Status;
import com.cdac.evillagers.master.entity.UserRegistration;
import com.cdac.evillagers.master.repository.RepositoryClass;
import com.cdac.evillagers.master.repository.VillagerRepository;

@RestController
@CrossOrigin
public class VillageController {

	@Autowired
	private VillagerRepository villagerRepository;
	@Autowired
	RepositoryClass resClass;
	
	@PostMapping("/registration")
	public void register(@RequestBody UserRegistration userRegistration) {

		System.out.println("in registration");
		villagerRepository.reg(userRegistration);

	}

	@PostMapping("/login")
	public Status login(@RequestBody UserRegistration userRegistration) {
		long count = villagerRepository.isValidUser(userRegistration.getUsername(), userRegistration.getPassword());

		if (count == 0) {
			long ac = resClass.isValidAdmin(userRegistration.getUsername(), userRegistration.getPassword());
			if (ac == 0) {
				Status status = new Status();
				status.setStatusCode(222);
				status.setStatusMessage("Invalid Username/Password");
				return status;
			}
			else
			{
				UserRegistration customer = new UserRegistration();
				customer.setFullname("Admin :: "+userRegistration.getUsername());
				Status status = new Status();
				status.setStatusCode(333);
				status.setStatusMessage("Login Successful");
				status.setLoggedInCustomer(customer);
				return status;
			}
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

	
}
