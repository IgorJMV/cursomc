package com.igormarinho.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EstadoPagamento {
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String description;
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) return null;
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(x.getCod() == cod) return x;
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}
