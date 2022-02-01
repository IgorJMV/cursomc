package com.igormarinho.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igormarinho.cursomc.domain.Pedido;
import com.igormarinho.cursomc.repositories.PedidoRepository;
import com.igormarinho.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll() {
		List<Pedido> list = repository.findAll();
		return list;
	}
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() ->
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id +
					", Tipo: " + Pedido.class.getName())
		);
	}
	
}
