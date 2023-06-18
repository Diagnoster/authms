package br.com.bantads.authms.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bantads.authms.dto.AuthDTO;
import br.com.bantads.authms.models.Auth;
import br.com.bantads.authms.repositories.AuthRepository;

@CrossOrigin
@RestController
public class AuthREST {

	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private ModelMapper mapper;

	//@Autowired
	//private PasswordEncoder passwordEncoder;

	@PostMapping("/auth")
	public ResponseEntity<AuthDTO> inserirAuth(@RequestBody AuthDTO auth) {
		if (authRepository.findByEmail(auth.getEmail()) == null) {
			authRepository.save(mapper.map(auth, Auth.class));
			Auth newAuth = authRepository.findByEmail(auth.getEmail());
			return ResponseEntity.status(201).body(mapper.map(newAuth, AuthDTO.class));
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@GetMapping("/")
	public String getString() {
		return "Olá";
	}

}
