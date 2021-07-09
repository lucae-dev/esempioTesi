package com.example.esempio.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UtenteDetailServiceimpl implements UserDetailsService {
	  
	 @Autowired
	   private UtenteRepository userRepository; 
	   
	
	   
	   @Override 
	   public UserDetails loadUserByUsername(String username) 
	   throws UsernameNotFoundException { 
	       
	         return  new MyUserDetails(userRepository.findUtenteByUsername(username) 
	    	         .orElseThrow(() -> new UsernameNotFoundException("User not present"))); 
	   } 
	   

	   public void createUser(UserDetails user) { 
	      userRepository.save((Utente) user); 
	   } 
	
}
