package com.igorjmv2000.gmail.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Setter private Integer id;
	@Setter private Date instante;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	@Setter private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@Setter private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	@Setter private Endereco enderecoDeEntrega;
	
	@OneToMany(mappedBy = "id.pedido")
	private final Set<ItemPedido> itens = new HashSet<>();

	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
}
