package com.Dinesh.Reservation.Services.impl;
import com.Dinesh.Reservation.Repository.UserRepository;
import com.Dinesh.Reservation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServieImpl implements UserDetailsService {
	@Autowired
	private UserRepository service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= this.service.findByUsername(username);
		if(user==null) {
			System.out.print("User Not Found");
			throw new UsernameNotFoundException("No user found!!!");
		}
		return user;
	}
}
