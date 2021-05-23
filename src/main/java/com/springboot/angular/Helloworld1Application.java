package com.springboot.angular;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.angular.domain.Categoria;
import com.springboot.angular.domain.Cidade;
import com.springboot.angular.domain.Cliente;
import com.springboot.angular.domain.Endereco;
import com.springboot.angular.domain.Estado;
import com.springboot.angular.domain.ItemPedido;
import com.springboot.angular.domain.Pagamento;
import com.springboot.angular.domain.PagamentoComBoleto;
import com.springboot.angular.domain.PagamentoComCartao;
import com.springboot.angular.domain.Pedido;
import com.springboot.angular.domain.Produto;
import com.springboot.angular.domain.enums.EstadoPagamento;
import com.springboot.angular.domain.enums.TipoCliente;
import com.springboot.angular.repository.CategoriaRepository;
import com.springboot.angular.repository.CidadeRepository;
import com.springboot.angular.repository.ClienteRepository;
import com.springboot.angular.repository.EnderecoRepository;
import com.springboot.angular.repository.EstadoRepository;
import com.springboot.angular.repository.ItemPedidoRepository;
import com.springboot.angular.repository.PagamentoRepository;
import com.springboot.angular.repository.PedidoRepository;
import com.springboot.angular.repository.ProdutoRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class Helloworld1Application implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository catrep;
	
	@Autowired
	private ProdutoRepository prod;
	
	@Autowired
	private CidadeRepository city;
	
	@Autowired
	private EstadoRepository states;
	
	@Autowired
	private ClienteRepository clie;
	
	@Autowired
	private EnderecoRepository endereco;
	
	@Autowired
	private PedidoRepository ped;
	
	@Autowired
	private PagamentoRepository pag;
	
	@Autowired
	private ItemPedidoRepository itemrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Helloworld1Application.class, args);
	}
	
	@Override
	public void run(String... args ) throws Exception{
		Categoria cat01 = new Categoria(null,"Hell World!");
		Categoria cat02 = new Categoria(null,"Salesforce");
		
		Produto p00 = new Produto(null,"Angular",13.50);
		Produto p01 = new Produto(null,"Java",13.50);
		Produto p02 = new Produto(null,"C#",13.50);
		
		Produto p10 = new Produto(null,"Tempo",13.50);
		Produto p11 = new Produto(null,"Chato",13.50);
		Produto p12 = new Produto(null,"Apex",13.50);
		Produto p13 = new Produto(null,"Xtudo",13.50);
		
		catrep.saveAll(Arrays.asList(cat01,cat02));
		
		cat01.getProduto().addAll(Arrays.asList(p00,p01,p02));
		cat02.getProduto().addAll(Arrays.asList(p10,p11,p12,p13));
		
		catrep.saveAll(Arrays.asList(cat01,cat02));
		
		p00.getCategoria().addAll(Arrays.asList(cat01));
		p01.getCategoria().addAll(Arrays.asList(cat01));
		p02.getCategoria().addAll(Arrays.asList(cat01));
		
		p10.getCategoria().addAll(Arrays.asList(cat02));
		p11.getCategoria().addAll(Arrays.asList(cat02));
		p12.getCategoria().addAll(Arrays.asList(cat02));
		p13.getCategoria().addAll(Arrays.asList(cat02,cat01));
		
		prod.saveAll(Arrays.asList(p00,p01,p02,p10,p11,p12,p13));
		
		Estado est00 = new Estado(null,"Minas Gerais");
		Estado est01 = new Estado(null,"São Paulo");
		
		states.saveAll(Arrays.asList(est00,est01));
		
		Cidade cid00 = new Cidade(null,"Hortolandia",est01);
		Cidade cid01 = new Cidade(null,"Campinas",est01);
		Cidade cid02 = new Cidade(null,"Rio Preto",est00);
		
		city.saveAll(Arrays.asList(cid00,cid01,cid02));
		
		est00.getCidades().addAll(Arrays.asList(cid00,cid01));
		est01.getCidades().addAll(Arrays.asList(cid02,cid00));
		
		Cliente cli00 = new Cliente(
					null,"Maria Silva",
					"maria.silva@gmail.com",
					"39994938838838",
					TipoCliente.PESSOAFISICA
				);
		cli00.getTelefone().addAll(Arrays.asList("39922887","199855669"));
		
		Endereco enderedo00 = new Endereco(
				    null,
					"Rua Flores",
					"300",
					"Apto 303",
					"Jardim",
					"388566466",
					 cli00,
					 cid02
				);
		
		Endereco enderedo01 = new Endereco(
			    null,
				"Avenida Sumaré",
				"105",
				"Sala 020",
				"Centro",
				"48855698",
				 cli00,
				 cid00
			);
		cli00.getEnderecos().addAll(Arrays.asList(enderedo00,enderedo01));
		
		clie.saveAll(Arrays.asList(cli00));
		endereco.saveAll(Arrays.asList(enderedo00,enderedo01));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped01 = new Pedido(null,sdf.parse("30/09/2020 10:32"),cli00,enderedo00);
		Pedido ped02 = new Pedido(null,sdf.parse("30/09/2019 10:32"),cli00,enderedo00);
		
		Pagamento pagar01 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped01,6);
	    ped01.setPagamento(pagar01);
	    
		Pagamento pagar02 = new PagamentoComBoleto(null,EstadoPagamento.PENDENETE,ped02,sdf.parse("30/10/2017 10:32"),null);
		ped02.setPagamento(pagar02);
		
		//cli00.getPedidos().addAll(Arrays.asList(ped01,ped02));
		
		clie.saveAll(Arrays.asList(cli00));
		ped.saveAll(Arrays.asList(ped01,ped02));
		//clie.saveAll(Arrays.asList(cli00));
		pag.saveAll(Arrays.asList(pagar01,pagar02));
		
		ItemPedido item00 = new ItemPedido(ped01,p00,0.00,1,2000.00);
		ItemPedido item01 = new ItemPedido(ped02,p01,0.00,5,3000.30);
		
		ped01.getItens().addAll(Arrays.asList(item00));
		ped02.getItens().addAll(Arrays.asList(item01));
		
		itemrepo.saveAll(Arrays.asList(item00,item01));
	}
}
