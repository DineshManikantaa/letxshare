package com.Dinesh.Reservation.Repository;

import com.Dinesh.Reservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long> {

	public User findByUsername(String username);
}
