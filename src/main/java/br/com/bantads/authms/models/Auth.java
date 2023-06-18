package br.com.bantads.authms.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_auth")
public class Auth implements Serializable, Comparable<Auth>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_auth")
	public String id;
	@Column(name="nome_auth")
	private String nome;
	@Column(name="email_auth", unique = true)
	private String email;
	@Column(name="senha_auth")
	private String senha;
	@Column(name="cargo_auth")
	private String cargo;
	
	@Override
	public int compareTo(Auth o) {
		return 0;
	}
	
	
}
