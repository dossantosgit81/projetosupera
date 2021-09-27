package br.com.mendes.services;

import java.util.List;

import br.com.mendes.domain.models.Product;

public interface ProductService {
	
	Product save(Product product);
	
	List<Product> orderByProduct();
	
}
