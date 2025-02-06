package com.ProductCrudApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ProductCrudApp.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//Create
	@Transactional
	public void createProduct(Product p)
	{
		hibernateTemplate.save(p);
	}
	
	//Read
	public List<Product> getProducts()
	{
		return hibernateTemplate.loadAll(Product.class);
	}
	
	//Read
	public Product getProduct(int id)
	{
		return hibernateTemplate.get(Product.class,id);
	}
	
	//Update
	@Transactional
	public void updateProduct(Product p)
	{
		hibernateTemplate.update(p);
	}
	
	//Delete
	@Transactional
	public void deleteProduct(int id)
	{
		Product p = hibernateTemplate.load(Product.class,id);
		hibernateTemplate.delete(p);
	}
}
