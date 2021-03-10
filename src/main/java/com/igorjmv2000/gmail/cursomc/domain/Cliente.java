package com.igorjmv2000.gmail.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.igorjmv2000.gmail.cursomc.domain.enums.TipoCliente;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Getter @Setter private Integer id;
	@Getter @Setter private String nome;
	@Getter @Setter private String email;
	@Getter @Setter private String cpfOuCnpj;
					private Integer tipo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	@Getter private final List<Pedido> pedidos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	@Getter private final List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "telefone")
	@Getter private final Set<String> telefones = new HashSet<>();
	
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod();
	}
	
	public void setTipoCliente(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
	
	public TipoCliente getTipoCliente() {
		return TipoCliente.valueOf(tipo);
	}
	
}
