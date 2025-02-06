package com.ProductCrudApp.controller;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.ProductCrudApp.dao.ProductDao;
import com.ProductCrudApp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products = productDao.getProducts();
		m.addAttribute("product",products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	@RequestMapping(path="/handle-product", method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)
	{
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/delete-product/{id}")
	public RedirectView deleteProduct(@PathVariable("id") int id,HttpServletRequest request)
	{
	    productDao.deleteProduct(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update-product/{id}")
	public String updateProduct(@PathVariable("id") int id, Model m)
	{
		Product p = productDao.getProduct(id); 
		m.addAttribute("product",p);
		return "update_product_form";
	}
	
	@RequestMapping(path="/product-updated", method=RequestMethod.POST)
	public RedirectView productUpdated(@ModelAttribute Product p, HttpServletRequest request)
	{
	    productDao.updateProduct(p);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
}
