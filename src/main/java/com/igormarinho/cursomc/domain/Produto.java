package com.igormarinho.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")

@NoArgsConstructor
@Getter
@EqualsAndHashCode(doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Setter
	private Integer id;
	@Setter
	private String nome;
	@Setter
	private Double preco;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria",
			   joinColumns = @JoinColumn(name = "produto_id"),
			   inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();

	public Produto(Integer id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> list = new ArrayList<>();
		for(ItemPedido x : itens) {
			list.add(x.getPedido());
		}
		
		return list;
	}
}
