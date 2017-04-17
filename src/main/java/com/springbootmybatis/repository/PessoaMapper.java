package com.springbootmybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.springbootmybatis.entity.Pessoa;

public interface PessoaMapper {
	@Select("select * from pessoa")
	@Results(value={
		@Result(column="id_pessoa",property="idPessoa"),
		@Result(column="nome",property="nome"),
		@Result(column="idade",property="idade")})
	public List<Pessoa> getAllPessoas();
}