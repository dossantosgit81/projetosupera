package br.com.mendes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.models.Product;
import br.com.mendes.domain.repositories.ProductRepository;
import br.com.mendes.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}

}
