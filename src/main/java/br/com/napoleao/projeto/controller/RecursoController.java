package br.com.napoleao.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.napoleao.projeto.dto.RecursoDTO;
import br.com.napoleao.projeto.dto.UsuarioDTO;
import br.com.napoleao.projeto.service.RecursoService;
import br.com.napoleao.projeto.service.UsuarioService;

@RestController
@RequestMapping(value = "/recurso")  
//CROSS ORIGIN - anotação necessário, erro CORS no browser(rede) pq não permite acesso de outra fonte. ADICIONADO NO APPLICATION.
public class RecursoController {
	
	@Autowired
	private RecursoService recursoService;
	
	@GetMapping
	public List<RecursoDTO> listarTodos(){
		return recursoService.listarTodos();
	}
	
//	@GetMapping("/{id}")
//	public RecursoDTO buscarPorId(@PathVariable("id") Long id){
//		recursoService.buscarPorId(id); 
//	}
	
	@PostMapping
	public void inserir(@RequestBody RecursoDTO recurso) {
		recursoService.inserir(recurso);
	}

	@PutMapping
	public RecursoDTO alterar(@RequestBody RecursoDTO recurso) {
		return recursoService.alterar(recurso);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		recursoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
