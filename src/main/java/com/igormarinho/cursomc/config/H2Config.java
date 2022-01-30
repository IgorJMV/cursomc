package com.igormarinho.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.igormarinho.cursomc.domain.Categoria;
import com.igormarinho.cursomc.domain.Produto;
import com.igormarinho.cursomc.repositories.CategoriaRepository;
import com.igormarinho.cursomc.repositories.ProdutoRepository;

@Configuration
public class H2Config implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		//Categoria
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		//Produtos
		Produto p1 = new Produto(null, "Computador", 2000d);
		Produto p2 = new Produto(null, "Impressora", 800d);
		Produto p3 = new Produto(null, "Mouse", 80d);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
