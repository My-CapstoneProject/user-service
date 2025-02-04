package com.sr.users_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String username;
	    private String password;
	    private String role;
	    private int status;

}
