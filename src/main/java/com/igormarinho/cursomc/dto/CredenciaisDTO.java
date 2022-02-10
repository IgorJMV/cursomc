package com.igormarinho.cursomc.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CredenciaisDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	
}
