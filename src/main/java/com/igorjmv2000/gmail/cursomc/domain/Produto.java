package com.igorjmv2000.gmail.cursomc.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Setter private Integer id;
	@Setter private String nome;
	@Setter private Double preco;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "produto_categoria",
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private final List<Categoria> categorias = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.produto")
	private final Set<ItemPedido> itens = new HashSet<>();
	
	public List<Pedido> getPedidos(){
		List<Pedido> list = new ArrayList<>();
		for(ItemPedido x : itens) {
			list.add(x.getPedido());
		}
		
		return list;
	}
}
