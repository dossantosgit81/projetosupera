package br.com.mendes.services;

import java.util.List;
import java.util.Optional;

import br.com.mendes.domain.dto.OrderProductsDTO;
import br.com.mendes.domain.models.Product;

public interface ProductService {
	
	Product save(Product product);
	
	List<OrderProductsDTO> findProductsOrderByPrice();
	
	List<OrderProductsDTO> findProductsOrderByScore();
	
	List<OrderProductsDTO> findProductOrderDescription();
	
	Optional<Product> findById(Long id);
	
}
