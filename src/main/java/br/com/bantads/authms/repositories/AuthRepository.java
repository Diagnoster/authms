package br.com.bantads.authms.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bantads.authms.models.Auth;

public interface AuthRepository extends JpaRepository<Auth, UUID> {
	
}
