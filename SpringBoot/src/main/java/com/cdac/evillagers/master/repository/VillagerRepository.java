package com.cdac.evillagers.master.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.evillagers.master.entity.AdminControl;
import com.cdac.evillagers.master.entity.PostPojo;
import com.cdac.evillagers.master.entity.Reply;
import com.cdac.evillagers.master.entity.UserRegistration;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class VillagerRepository {

	@PersistenceContext
	private EntityManager villagerManager;

	@Transactional
	public void postSave(PostPojo p) {

		switch (p.getDept()) {
		case "water":
			p.setDateline(LocalDateTime.now().plusDays(2));
			System.out.println("water problem!");

			break;
		case "agriculture":
			p.setDateline(LocalDateTime.now().plusDays(4));
			System.out.println("agriculture problem!");
			break;
		case "road":
			p.setDateline(LocalDateTime.now().plusDays(5));
			System.out.println("road problem!");

			break;
		case "education":
			p.setDateline(LocalDateTime.now().plusDays(1));
			System.out.println("education problem!");

			break;
		case "health":
			p.setDateline(LocalDateTime.now().plusDays(1));
			System.out.println("health problem!");

			break;
		case "garbage":
			p.setDateline(LocalDateTime.now().plusDays(2));
			System.out.println("garbage problem!");

			break;
		case "drainage":
			p.setDateline(LocalDateTime.now().plusDays(1));
			System.out.println("drainage problem!");

			break;
		default:
			p.setDateline(LocalDateTime.now().plusDays(10));
			System.out.println("default problem!");

			break;

		}
		p.setStatuslevel("level-4");

		villagerManager.persist(p);
		System.out.println("posted successfully123456!!!");
	}

	@Transactional
	public void reg(Object obj) {

		villagerManager.persist(obj);
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

	public List<PostPojo> getAllpost() {
		try {
			return (List<PostPojo>) villagerManager.createQuery("select a from PostPojo a").getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public UserRegistration getUser(String name) {
		try {
			System.out.println("hiiii...");
			System.out.println(name);
			return (UserRegistration) villagerManager
					.createQuery("select a from UserRegistration a where a.username=:usr").setParameter("usr", name)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public void update(UserRegistration userupDate) {
		villagerManager.merge(userupDate);

	}

	@Transactional
	public Object reply(int postId) {

		return (String) villagerManager
				.createNativeQuery("select content from er_reply where complaint_id order by id desc limit 1")
				.getSingleResult();

		// return (List<Reply>)villagerManager.createNatQuery("select a.content from
		// Reply a where a.postId=:pi").setParameter("pi",postId).getResultList();

	}

	@Transactional
	public List<Reply> fetchComment(int complaintId) {
		System.out.println("hello");

		return (List<Reply>) villagerManager.createQuery("select a.content from Reply a where a.complaintId=:ci")
				.setParameter("ci", complaintId).getResultList();
//		System.out.println(l);
//		 List<Reply> List = null;
//		return List;
	}

	@Transactional
	public void commentSave(Reply re) {

		re.setDateOfReply(LocalDateTime.now());
		System.out.println("in saving comment");
		villagerManager.persist(re);
	}

}
