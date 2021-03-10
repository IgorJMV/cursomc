package com.igorjmv2000.gmail.cursomc.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum EstadoPagamento {
	PENDENTE (1, "Pendente"),
	QUITADO (2, "Quitado"),
	CANCELADO (3, "Cancelado");
	
	private int cod;
	private String description;
	
	public static EstadoPagamento valueOf(Integer cod) {
		if(cod == null)
			return null;
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(x.getCod() == cod.intValue()) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido! Cod: " + cod);
	}
}
