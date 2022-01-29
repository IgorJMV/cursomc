package com.igormarinho.cursomc.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> buscar(){
		String body = "As categorias serão listadas aqui...";
		return ResponseEntity.ok().body(body);
	}
	
}
