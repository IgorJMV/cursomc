package com.igormarinho.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int cod;
	private String description;
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) return null;
		for(Perfil x : Perfil.values()) {
			if(x.getCod() == cod) return x;
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}
