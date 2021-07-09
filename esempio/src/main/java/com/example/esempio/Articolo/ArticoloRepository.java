package com.example.esempio.Articolo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticoloRepository extends JpaRepository <Articolo, Integer>{

	//@Query("SELECT a FROM ARTICOLI a WHERE a.nome=?1")
	//Optional<Articolo> findByNome(String nome);

}
