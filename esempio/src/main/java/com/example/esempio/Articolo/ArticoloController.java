package com.example.esempio.Articolo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.esempio.User.MyUserDetails;
import com.example.esempio.User.Utente;
import com.example.esempio.User.UtenteDetailServiceimpl;
import com.example.esempio.User.UtenteRepository;

@RestController
@RequestMapping(value="/articoloRest")
public class ArticoloController {

	private ArticoloService AS;
	private  UtenteDetailServiceimpl US;
	private UtenteRepository UR;
	
	@Autowired
	public ArticoloController(ArticoloService articoloservice, UtenteDetailServiceimpl us, UtenteRepository ur)
	{
		super();
		this.AS=articoloservice;
		this.US=us;
		this.UR=ur;
	}
	
	@PostMapping(value="/add")
	public void addArticolo(@RequestBody Articolo art)
	{
		AS.addArticolo(art);
	}
	
	@GetMapping(value="/getAll")
	public List<Articolo> getAllArticoli()
	{
		return AS.getAllArticoli();
	}
	
	@GetMapping(value="/getArticolo/{cod}")
	public Articolo getArticolo(@PathVariable Integer cod)
	{
		return AS.getArticoloById(cod);
	}
	
	@PutMapping(value="/update/{cod}")
	public void updateQuantity(@PathVariable Integer cod, @RequestParam Integer q)
	{
		AS.updateQuantitaArticolo(cod, q);
	}
	
	@DeleteMapping(value="/delete/{cod}")
	public void deleteArticolo(@PathVariable Integer cod)
	{
		AS.deleteArticoloByCodice(cod);
	}
	
	
	
	@GetMapping(value="/testu")
	public void speriamo()
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String passw="esempiotesi";
		String enpass= encoder.encode(passw);
		
		System.out.println(enpass) ;
		
		UserDetails ut =  US.loadUserByUsername("Luca");
		
		Optional<Utente> sp = UR.findUtenteByUsername("Luca");
		
		
		
		System.out.println( sp.get().getPassword());
		System.out.println(ut.getUsername());
		
		System.out.println( encoder.matches(passw, sp.get().getPassword()));
	
	}
	
}
