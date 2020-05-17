package com.cdac.evillagers.master.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.evillagers.master.entity.AdminControl;
import com.cdac.evillagers.master.entity.StatusMessage;
import com.cdac.evillagers.master.repository.RepositoryClass;

@RestController
@CrossOrigin
public class adminServices {
	@Autowired
	RepositoryClass resClass;
	/*@GetMapping("/noa")
	public int getnoofadmin()
	{
		return resClass.getNoofAdmins();
	}*/
	
	@PostMapping("/reg")
	public StatusMessage addNew(@RequestBody AdminControl admin)
	{
		StatusMessage msg = new StatusMessage();
		if(resClass.getAdmin(admin.getAdminName())==null)
		{	
		admin.setStatus(false);
		resClass.update(admin);
		msg.status=200;
		msg.message="Admin Member Added Successfully";
		System.out.println("reg");
		}
		else
		{
			//System.out.println("Not reg");
			msg.status=404;
			msg.message="Admin Member Already Register";
		}
		return msg;
	}
	@PostMapping("/update")
	public StatusMessage updateAdmin(@RequestBody AdminControl admin)
	{
		AdminControl adm = resClass.getAdmin(admin.getAdminName());
		admin.setId(adm.getId());
		StatusMessage msg = new StatusMessage();
		if(adm!=null)
		{	
		resClass.update(admin);
		msg.status=200;
		msg.message="Admin Information Updated Successfully";
		}
		else
		{
			msg.status=404;
			msg.message="Admin Information Update Failed";
		}
		return msg;
	}
	@PostMapping("/verify")
	public StatusMessage verifyAdmin(@RequestBody AdminControl admin)
	{
		AdminControl adm = resClass.getVerify(admin.getAdminName());
		StatusMessage msg = new StatusMessage();
		
		if(adm!=null)
		{
			adm.setPrevillageLevel(admin.getPrevillageLevel());
			adm.setStatus(admin.isStatus());
			adm.setPassword(admin.getPassword());
			//if(admin.isStatus())
			resClass.update(adm);
			msg.status=200;
			msg.message="Admin Member Added Successfully";
			return msg;
		}
		msg.message="Memeber Verification Failed";
		msg.status=404;
		return msg;
	}
	
	@PostMapping("/adminfetch")
	public AdminControl getAdmin(@RequestBody AdminControl admin)
	{
		return resClass.getAdmin(admin.getAdminName());
	}
	
	@PostMapping("/admins")
	public List<AdminControl> getAdmins(@RequestBody AdminControl admin)
	{
		return resClass.getAllAdmin();
	}
	
	@PostMapping("/resetpass")
	public StatusMessage resetPassword(@RequestBody AdminControl admin)
	{
		AdminControl adm = resClass.getVerify(admin.getAdminName());
		StatusMessage msg = new StatusMessage();
		
		if(adm!=null)
		{
			adm.setPassword(admin.getPassword());
			resClass.update(adm);
			msg.status=200;
			msg.message="Password Updated Successfully";
			return msg;
		}
		msg.message="Password Reset Failed";
		msg.status=404;
		return msg;
	}
	
	@GetMapping("/notify")
	public String getService()
	{
		System.out.println("Req.. 4200");
		return "";
	}
}
