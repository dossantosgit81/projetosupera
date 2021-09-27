package br.com.mendes.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mendes.domain.dto.OrderProductsDTO;
import br.com.mendes.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private ProductService prodService;
	
	@GetMapping(value = "/order-price")
	public List<OrderProductsDTO> findOrderPrice(){
		return prodService.findProductsOrderByPrice();
	}
	
	@GetMapping(value="/order-score")
	public List<OrderProductsDTO> findOrderScore(){
		return prodService.findProductsOrderByScore();
	}
	
	@GetMapping(value="/order-description")
	public List<OrderProductsDTO> findProductsOrderBydescription(){
		return prodService.findProductOrderDescription();
	}

}
