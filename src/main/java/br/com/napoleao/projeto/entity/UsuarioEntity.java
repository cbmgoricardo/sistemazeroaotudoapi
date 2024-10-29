package br.com.napoleao.projeto.entity;

import org.springframework.beans.BeanUtils;

import br.com.napoleao.projeto.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "NPL_USUARIO")
@Data
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String login;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String email;
	
	public UsuarioEntity(UsuarioDTO usuario) {
		BeanUtils.copyProperties(usuario, this);
	}
	
	public UsuarioEntity() {
		
	}	
	
}
