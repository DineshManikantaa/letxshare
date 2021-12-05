package com.Dinesh.Reservation.controller;

import java.util.HashSet;
import java.util.Set;

import com.Dinesh.Reservation.Services.UserService;
import com.Dinesh.Reservation.model.Role;
import com.Dinesh.Reservation.model.User;
import com.Dinesh.Reservation.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	
	
	@Autowired
	private UserService userservice;
	

	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	

	
	@PostMapping("/createuseradm")
	public User usercreateadm(@RequestBody User uc) throws Exception {
		uc.setPassword(this.bcryptPasswordEncoder.encode(uc.getPassword()));
		Set<UserRole> ur=new HashSet<>();
		Role r=new Role();
		r.setRoleid(44L);
		r.setRolename("ADMIN");
		
		UserRole urt=new UserRole();
		urt.setUser(uc);
		urt.setRole(r);
		ur.add(urt);
		
		return this.userservice.createuser(uc, ur);
		
		
	}
	
	@GetMapping("/{id}")
	public User userbyid(@PathVariable("id") Long id) {
		return this.userservice.userbyid(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable("id") Long id) {
		this.userservice.userdeletebyid(id);
		
	}
	
	@PutMapping("/update")
	public User updateuser(@RequestBody User update) {
		return this.userservice.updateuser(update);
	}
	
	@GetMapping("/showall")
	public Set<User> showall(){
		return this.userservice.alluser();
	}
	
	
	
	
	

}
