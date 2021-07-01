package com.example.esempio.Articolo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticoloService {

	private final ArticoloRepository AR;
	
	@Autowired
	public ArticoloService(ArticoloRepository articolorepository)
	{
		super();
		this.AR=articolorepository;
	}
	
	public void addArticolo(Articolo art)
	{
		Optional<Articolo> arto = AR.findById(art.getCodice());
		if(arto.isPresent())
		{
			throw new IllegalStateException("l'articolo è gia presente!");
		}
		
		AR.save(art);
	}
	
	public List<Articolo> getAllArticoli()
	{
		return AR.findAll();
	}
	
	public Articolo getArticoloById(Integer codice)
	{
		Articolo art=AR.findById(codice).orElseThrow(()->new IllegalStateException("L'articolo non è presente nel database!"));
		return art;
	}
	  
	public void updateQuantitaArticolo(Integer codice, Integer q)
	{
		Articolo art = AR.findById(codice).orElseThrow(()->new IllegalStateException("L'articolo non può essere modificato perchè non è presente nel database"));
		if((-q)>art.getQuantita())
		{
			throw new IllegalStateException("Non ci sono abbastanza unità di questo articolo!");
		}
		
		art.setQuantita(art.getQuantita()+q);
		AR.save(art);
	}
	
	public void deleteArticoloByCodice(Integer cod)
	{
		if(!(AR.existsById(cod)))
		{
			throw new IllegalStateException("L'articolo da eliminare non è presente nel database."); 
		}
		AR.deleteById(cod);
	}
	
	
}
