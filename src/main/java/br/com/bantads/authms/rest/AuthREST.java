package br.com.bantads.authms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


import br.com.bantads.authms.repositories.AuthRepository;

@CrossOrigin
@RestController
public class AuthREST {

	@Autowired
	private AuthRepository repo;
	
	//@Autowired
	//private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
}
