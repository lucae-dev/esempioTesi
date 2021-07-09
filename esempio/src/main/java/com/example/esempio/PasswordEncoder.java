package com.example.esempio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.esempio.User.Utente;
import com.example.esempio.User.UtenteDetailServiceimpl;
import com.example.esempio.User.UtenteRepository;

public class PasswordEncoder {

	
	private static UtenteDetailServiceimpl US;
	
	
	public static void main (String args[])
	{

		US=new UtenteDetailServiceimpl();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String passw="esempiotesi";
		String enpass= encoder.encode(passw);
		
		System.out.println(enpass) ;
		
		Utente ut = (Utente) US.loadUserByUsername("Luca");
		
		System.out.println( encoder.matches(passw, ut.getPassword()));
	}
	
	
}
