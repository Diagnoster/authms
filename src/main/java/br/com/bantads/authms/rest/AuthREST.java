package br.com.bantads.authms.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/auth")
    public ResponseEntity<AuthDTO> alterarLogin(@RequestBody AuthDTO auth) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/auth/{email}")
    public ResponseEntity<AuthDTO> buscarLogin(@PathVariable("email") String email) {
    	Auth authh = authRepository.findByEmail(email);
    	if (authh != null)
    		return ResponseEntity.status(200).body(mapper.map(authh, AuthDTO.class));
    	else
			return ResponseEntity.status(401).build();
    }
	
    //login
	@PostMapping("/login")
	public ResponseEntity<AuthDTO> login(@RequestBody AuthDTO auth) {
		String email = auth.getEmail();
		String senha = auth.getSenha();
		
		Auth authh = authRepository.findByEmail(email);
		
		if(authh != null && authh.getSenha().equals(senha) && authh.getEmail().equals(email)) {
			return ResponseEntity.status(200).body(mapper.map(authh, AuthDTO.class));
		} else {
			return ResponseEntity.status(401).build();
		}
	}
}
