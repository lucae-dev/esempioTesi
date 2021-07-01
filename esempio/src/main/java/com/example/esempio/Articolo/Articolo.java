package com.example.esempio.Articolo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARTICOLI")
public class Articolo {
	
	@Id
	@Column(name="CODICE", updatable=false)
	private Integer codice;
	
	@Column(name="NOME")
	private String nome;

	@Column(name="DESCRIZIONE")
	private String descrizione;
	
	@Column(name="PREZZO")
	private float prezzo;
	
	@Column(name="QUANTITA")
	private Integer quantita;
	
	public Articolo(Integer codice, String nome, String descrizione, float prezzo, Integer quantita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	
	public Articolo()
	{
		super();
	}
	
	public Articolo(Articolo art)
	{
		this.codice = art.codice;
		this.descrizione = art.descrizione;
		this.nome = art.nome;
		this.prezzo = art.prezzo;
		this.quantita = art.quantita;
	}
	
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	

	
}
