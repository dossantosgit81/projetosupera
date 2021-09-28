package br.com.mendes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.dto.OrderProductsDTO;
import br.com.mendes.domain.models.Product;
import br.com.mendes.domain.repositories.ProductRepository;
import br.com.mendes.domain.repositories.jdbcutils.JDBCUtilRepository;
import br.com.mendes.exception.ResourceNotFoundException;
import br.com.mendes.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private JDBCUtilRepository jdbcRepo;

	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<OrderProductsDTO> findProductsOrderByPrice() {
		return jdbcRepo.findProductOrderPrice();
	}

	@Override
	public List<OrderProductsDTO> findProductsOrderByScore() {
		return jdbcRepo.findProductOrderScore();
	}

	@Override
	public List<OrderProductsDTO> findProductOrderDescription() {
		return jdbcRepo.findProductOrderDescription();
	
	}

	@Override
	public Optional<Product> findById(Long id) {
		
		Optional<Product> searchEdproduct = productRepository.findById(id);
		
		if(searchEdproduct.isEmpty()) {
			throw new ResourceNotFoundException("Produto não encontrado");
		}
		
		return searchEdproduct;
	}

}
