package com.example.esempio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.esempio.User.Utente;
import com.example.esempio.User.UtenteDetailServiceimpl;
import com.example.esempio.User.UtenteRepository;

@SpringBootApplication
public class EsempioApplication {
	@Autowired
	private static UtenteDetailServiceimpl US;

	
	public static void main(String[] args) {
		
		SpringApplication.run(EsempioApplication.class, args);
		
		
	
		
	}

}
