package com.igormarinho.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.igormarinho.cursomc.domain.Categoria;
import com.igormarinho.cursomc.domain.Cidade;
import com.igormarinho.cursomc.domain.Cliente;
import com.igormarinho.cursomc.domain.Endereco;
import com.igormarinho.cursomc.domain.Estado;
import com.igormarinho.cursomc.domain.ItemPedido;
import com.igormarinho.cursomc.domain.Pagamento;
import com.igormarinho.cursomc.domain.PagamentoComBoleto;
import com.igormarinho.cursomc.domain.PagamentoComCartao;
import com.igormarinho.cursomc.domain.Pedido;
import com.igormarinho.cursomc.domain.Produto;
import com.igormarinho.cursomc.domain.enums.EstadoPagamento;
import com.igormarinho.cursomc.domain.enums.TipoCliente;
import com.igormarinho.cursomc.repositories.CategoriaRepository;
import com.igormarinho.cursomc.repositories.CidadeRepository;
import com.igormarinho.cursomc.repositories.ClienteRepository;
import com.igormarinho.cursomc.repositories.EnderecoRepository;
import com.igormarinho.cursomc.repositories.EstadoRepository;
import com.igormarinho.cursomc.repositories.ItemPedidoRepository;
import com.igormarinho.cursomc.repositories.PagamentoRepository;
import com.igormarinho.cursomc.repositories.PedidoRepository;
import com.igormarinho.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void instantiateTestDatabase() throws ParseException {
		// Categoria
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Categoria cat8 = new Categoria(null, "Aviação");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));

		// Produtos
		Produto p1 = new Produto(null, "Computador", 2000d);
		Produto p2 = new Produto(null, "Impressora", 800d);
		Produto p3 = new Produto(null, "Mouse", 80d);
		Produto p4 = new Produto(null, "Mesa de escritório", 300d);
		Produto p5 = new Produto(null, "Toalha", 50d);
		Produto p6 = new Produto(null, "Colcha", 200d);
		Produto p7 = new Produto(null, "TV True Color", 1200d);
		Produto p8 = new Produto(null, "Roçadeira", 800d);
		Produto p9 = new Produto(null, "Abajur", 100d);
		Produto p10 = new Produto(null, "Pendente", 180d);
		Produto p11 = new Produto(null, "Shampoo", 90d);

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		// Estados
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		estadoRepository.saveAll(Arrays.asList(est1, est2));

		// Cidades
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		// Clientes
		Cliente cli1 = new Cliente(null, "Maria", "maria@gmail.com", "059.032.200-55", TipoCliente.PESSOA_FISICA, bCryptPasswordEncoder.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("(27) 92222-5555", "(27) 98777-0255"));

		clienteRepository.saveAll(Arrays.asList(cli1));

		// Endereços
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "22455-850", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Matos", "105", "Sala 800", "Centro", "38559-888", cli1, c2);

		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		// Pedidos
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, df.parse("01/02/2022 15:54"), cli1, e1);
		Pedido ped2 = new Pedido(null, df.parse("10/02/2022 14:35"), cli1, e2);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

		// Pagamentos
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped2, 6);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped1, df.parse("20/03/2022 00:00"),
				null);

		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		// Item de Pedidos
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0d, 1, 2000d);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0d, 2, 80d);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100d, 1, 800d);

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
