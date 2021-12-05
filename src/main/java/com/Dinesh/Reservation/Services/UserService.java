package com.Dinesh.Reservation.Services;

import com.Dinesh.Reservation.model.User;
import com.Dinesh.Reservation.model.UserRole;

import java.util.Set;


public interface UserService {
	
	public User createuser(User user, Set<UserRole> userrole) throws Exception;
	
    public User userbyid(Long id);
    
    public void userdeletebyid(Long id);
    
    public User updateuser(User user);
    
    public User userbyname(String username);
    
    public Set<User> alluser();
	

}

