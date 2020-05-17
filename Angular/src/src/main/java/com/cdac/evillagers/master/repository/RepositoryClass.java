package com.cdac.evillagers.master.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdac.evillagers.master.entity.AdminControl;
import com.cdac.evillagers.master.entity.Reply;
import com.cdac.evillagers.master.entity.StatusMessage;
import com.cdac.evillagers.master.entity.UserRegistration;

import ch.qos.logback.core.status.Status;

@Repository
public class RepositoryClass {

	@PersistenceContext
	private EntityManager entityManager;
	
	@org.springframework.transaction.annotation.Transactional
	public void update(Object reqObj)
	{
		entityManager.merge(reqObj);
	}
	
	public Reply getReply()
	{
		int pid=1;
		try
		{
			return (Reply)entityManager.createQuery("select r from Reply r where r.postID=:PID")
					.setParameter("PID",pid).getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
		
	}
	
	public List<Reply> getAllReplies()
	{
		try
		{
		List<Reply> lstReply = entityManager.createQuery("select r from Reply r").getResultList();
		return lstReply;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public AdminControl getVerify(String name)
	{
		try
		{
		return (AdminControl)entityManager.createQuery("select a from AdminControl a where adminName=:admn")
		.setParameter("admn",name).getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}
	public List<AdminControl> getAllAdmin()
	{
		try
		{
		return (List<AdminControl>)entityManager.createQuery("select a from AdminControl a").getResultList();
		}
		catch (Exception e) {
			return null;
		}
	}
	public AdminControl getAdmin(String name)
	{
		try
		{
		return (AdminControl)entityManager.createQuery("select a from AdminControl a where a.adminName=:admn")
				.setParameter("admn", name).getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}
	public int isValidAdmin(String username, String password) {
		List<AdminControl> ul = (List<AdminControl>) entityManager
				.createQuery("select c from AdminControl c where c.adminName=:un and c.password=:pwd")
				.setParameter("un", username).setParameter("pwd", password).getResultList();
		//System.out.println(ul.size());
		return ul.size();
	}
	public int getNoofAdmins()
	{
		List<AdminControl> lst =(List<AdminControl>)entityManager.createQuery("select a from AdminControl a where a.adminName='@akmaster'").getResultList();
		return lst.size();
	}
}
