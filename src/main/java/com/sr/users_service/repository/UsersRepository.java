package com.sr.users_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sr.users_service.entity.Users;

//import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users,Integer> {
	 Optional<Users> findByUsername(String username);
	    boolean existsByUsername(String username);
	    List<Users> findByStatus(int status);
	
	

}
