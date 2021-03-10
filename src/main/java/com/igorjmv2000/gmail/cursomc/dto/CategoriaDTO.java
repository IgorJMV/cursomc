package com.igorjmv2000.gmail.cursomc.dto;

import java.io.Serializable;

import com.igorjmv2000.gmail.cursomc.domain.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CategoriaDTO(Categoria entity) {
		id = entity.getId();
		nome = entity.getNome();
	}
	
}
