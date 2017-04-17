package com.springbootmybatis.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@MapperScan("com.springbootmybatis.repository")
public class AppConfig {
	    @Bean
	    public DataSource getDataSource() {
	       BasicDataSource dataSource = new BasicDataSource();
	       dataSource.setDriverClassName("org.postgresql.Driver");
	       dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
	       dataSource.setUsername("postgres");
	       dataSource.setPassword("12345");
	       return dataSource;
	   }
	   @Bean
	   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	      sessionFactory.setDataSource(dataSource);
	      return sessionFactory.getObject();
	   }
} 