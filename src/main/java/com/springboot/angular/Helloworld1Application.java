package com.springboot.angular;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.angular.domain.Categoria;
import com.springboot.angular.domain.Produto;
import com.springboot.angular.repository.CategoriaRepository;
import com.springboot.angular.repository.ProdutoRepository;
@EnableAutoConfiguration
@SpringBootApplication
public class Helloworld1Application implements CommandLineRunner {
	@Autowired
	private CategoriaRepository catrep;
	
	@Autowired
	private ProdutoRepository prod;
	
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
	}
}
