package com.igormarinho.cursomc.domain;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pedido")

@NoArgsConstructor
@Getter
@EqualsAndHashCode(doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Setter
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Setter
	private Date instant;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	@Setter
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@Setter
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_de_entrega_id")
	@Setter
	private Endereco enderecoDeEntrega;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();

	public Pedido(Integer id, Date instant, Cliente cliente, Endereco enderecoDeEntrega) {
		this.id = id;
		this.instant = instant;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
}
