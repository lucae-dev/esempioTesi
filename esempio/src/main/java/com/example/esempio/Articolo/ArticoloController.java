package com.example.esempio.Articolo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value="/articoloRest")
public class ArticoloController {

	private ArticoloService AS;
	
	@Autowired
	public ArticoloController(ArticoloService articoloservice)
	{
		super();
		this.AS=articoloservice;
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
	
}
