package com.igormarinho.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.igormarinho.cursomc.domain.Categoria;
import com.igormarinho.cursomc.domain.Cidade;
import com.igormarinho.cursomc.domain.Cliente;
import com.igormarinho.cursomc.domain.Endereco;
import com.igormarinho.cursomc.domain.Estado;
import com.igormarinho.cursomc.domain.Produto;
import com.igormarinho.cursomc.domain.enums.TipoCliente;
import com.igormarinho.cursomc.repositories.CategoriaRepository;
import com.igormarinho.cursomc.repositories.CidadeRepository;
import com.igormarinho.cursomc.repositories.ClienteRepository;
import com.igormarinho.cursomc.repositories.EnderecoRepository;
import com.igormarinho.cursomc.repositories.EstadoRepository;
import com.igormarinho.cursomc.repositories.ProdutoRepository;

@Configuration
public class H2Config implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

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
		
		//Estados
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
		//Cidades
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Clientes
		Cliente cli1 = new Cliente(null, "Maria", "maria@gmail.com", "059.032.200-55", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("(27) 92222-5555", "(27) 98777-0255"));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		//Endereços
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "22455-850", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Matos", "105", "Sala 800", "Centro", "38559-888", cli1, c2);
		
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
