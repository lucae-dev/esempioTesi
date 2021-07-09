package com.example.esempio.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {

	@Query("SELECT u FROM Utente u WHERE u.username = ?1")
	Optional<Utente> findUtenteByUsername(String username);

	
	
}
