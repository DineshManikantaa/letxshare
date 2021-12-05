package com.Dinesh.Reservation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userroleid;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToOne()
	private Role role;
}
