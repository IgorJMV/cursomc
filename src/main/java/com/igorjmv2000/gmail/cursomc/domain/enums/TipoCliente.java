package com.igorjmv2000.gmail.cursomc.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TipoCliente {
	PESSOA_FISICA (1, "Pessoa Física"),
	PESSOA_JURIDICA (2, "Pessoa Jurídica");
	
	private int cod;
	private String description;
	
	public static TipoCliente valueOf(Integer cod) {
		if(cod == null)
			return null;
		
		for(TipoCliente x : TipoCliente.values()) {
			if(x.getCod() == cod) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido! Cod: " + cod);
	}
}
