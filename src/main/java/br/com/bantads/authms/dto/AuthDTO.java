package br.com.bantads.authms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

	private Integer id;
	
	private String email;
	
	private String senha;
	
	private String cargo;
	
	
}
