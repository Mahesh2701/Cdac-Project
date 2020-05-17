package com.cdac.evillagers.master.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.evillagers.master.entity.AdminControl;
import com.cdac.evillagers.master.entity.Reply;
import com.cdac.evillagers.master.entity.StatusMessage;
import com.cdac.evillagers.master.repository.RepositoryClass;

@RestController
@CrossOrigin
public class masterServices {
	
	@Autowired
	private RepositoryClass repositoryClass;

	/*
	 * @PostMapping("/reg") void addNew(@RequestBody AdminControl admin) {
	 * admin.setStatus(false); repositoryClass.update(admin); }
	 */
	@PostMapping("/replyonsolve")
	public StatusMessage setReply(@RequestBody Reply reply)
	{
		/*Reply reply =  new Reply();
		reply.setContent("problem of road");
		*/
		reply.setDateOfReply(LocalDateTime.now());
		/*reply.setForwardto("@admin2");
		reply.setPostID(20);*/
		repositoryClass.update(reply);
		StatusMessage msg = new StatusMessage();
		msg.message="Reply Send Successfully";
		msg.status=200;
		System.out.println(reply.getContent());
		return msg;
	}
	
	@GetMapping("/getReply")
	public StatusMessage getReply()
	{
		StatusMessage msg = new StatusMessage();
		msg.status=200;
		msg.message=repositoryClass.getReply();
		return msg;
	}
	
	@GetMapping("/lstreply")
	public List<Reply> getData()
	{
		return repositoryClass.getAllReplies();
	}
	
}
