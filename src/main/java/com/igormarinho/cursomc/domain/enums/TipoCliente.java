package com.igormarinho.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoCliente {
	PESSOA_FISICA(1, "Pessoa Física"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String description;
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) return null;
		for(TipoCliente x : TipoCliente.values()) {
			if(x.getCod() == cod) return x;
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}
