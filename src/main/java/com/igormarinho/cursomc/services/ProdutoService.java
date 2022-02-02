package com.igormarinho.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.igormarinho.cursomc.domain.Categoria;
import com.igormarinho.cursomc.domain.Produto;
import com.igormarinho.cursomc.repositories.CategoriaRepository;
import com.igormarinho.cursomc.repositories.ProdutoRepository;
import com.igormarinho.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Produto> findAll() {
		List<Produto> list = repository.findAll();
		return list;
	}
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() ->
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id +
					", Tipo: " + Produto.class.getName())
		);
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
	
}
