package com.springbootmybatis.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.springbootmybatis.entity.Pessoa;
import com.springbootmybatis.repository.PessoaMapper;

@SpringBootApplication
@ComponentScan("com.springbootmybatis")
public class Application implements CommandLineRunner{
	@Autowired
	private PessoaMapper auxPessoaMapper;
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n");
		for(Pessoa pessoa : auxPessoaMapper.getAllPessoas()){
			System.out.println("ID: " + pessoa.getIdPessoa());
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Idade: " + pessoa.getIdade() + "\n\n");
		}	
	}
}