package com.evillager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class VillagerRepository {

	@PersistenceContext
	private EntityManager villagerManager;

	@Transactional
	public void reg(UserRegistration userRegistered) {

		villagerManager.persist(userRegistered);

		System.out.println("User Registered successfully!!!");

	}

	public int isValidUser(String username, String password) {
		
		List<UserRegistration> ul = (List<UserRegistration>) villagerManager
				.createQuery("select c from UserRegistration c where c.username=:un and c.password=:pwd")
				.setParameter("un", username).setParameter("pwd", password).getResultList();
		System.out.println(ul.size());
		return ul.size();
		
	}

	public UserRegistration fetch(String username) {

		return (UserRegistration) villagerManager
				.createQuery("select c from UserRegistration c where c.username = : un").setParameter("un", username)
				.getSingleResult();

	}

	@Transactional
	public void postSave(PostPojo p) {
		
		
		System.out.println(LocalDateTime.now());
		
		villagerManager.persist(p);
		System.out.println("posted successfully!!!");

	}

}
