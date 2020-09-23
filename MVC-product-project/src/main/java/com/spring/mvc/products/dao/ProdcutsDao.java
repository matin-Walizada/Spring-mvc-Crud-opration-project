package com.spring.mvc.products.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.mvc.products.entity.Products;

@Repository
public class ProdcutsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Save product
	public void save(Products product) {

		String sql = "insert into products_tbl(name,brand,doe) values(?,?,?)";
		Object[] data = { product.getName(), product.getBrand(), product.getDoe() };
		jdbcTemplate.update(sql, data);

	}

	// get product
	public List<Products> getAllProducts() {

		List<Products> myProducts = jdbcTemplate.query("select id,name,brand,doe from products_tbl",
				new BeanPropertyRowMapper(Products.class));

		return myProducts;

	}

	// delete product
	public String deleteByName(String name) {
		int rows = jdbcTemplate.update("delete from products_tbl where name = ?", name);
		String result = "Number of row deleted is  = " + rows;
		return result;
	}
	 
	
	public Products findById(int did) {
		String sql = "select id,name,brand,doe from products_tbl where id = " + did;
		
		List<Products> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Products.class));
		return productList.size() == 1 ? productList.get(0) : null;
	}
	
	
	public void updateProduct(Products product) {
		String sql = "update products_tbl set name = ?, brand = ? where id = ?";
				Object[] data = {product.getName(),  product.getBrand(), product.getId()};
						
		jdbcTemplate.update(sql,data);
		
		
	}
	
	public byte[] renderPhoto(int dbid) {
		
		byte[] photo=jdbcTemplate.queryForObject("select photo from products_tbl where id = " + dbid, byte[].class);
		return photo;
	}
	
	


}
