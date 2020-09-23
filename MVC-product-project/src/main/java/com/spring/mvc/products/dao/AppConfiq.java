package com.spring.mvc.products.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class AppConfiq {

	// provide our database url, username and password

	@Bean
	public DataSource dataSource() {

		MysqlDataSource theDataSource = new MysqlDataSource();

		theDataSource.setUrl("jdbc:mysql://localhost:3306/academy_products?createDatabaseIfNotExist=true");
		theDataSource.setUser("matin");
		theDataSource.setPassword("1989");

		return theDataSource;

	}

	@Bean("jdbcTemplate")
	public JdbcTemplate createTemplate() {

		JdbcTemplate theJdbcTemplate = new JdbcTemplate(this.dataSource());

		return theJdbcTemplate;
	}

}
