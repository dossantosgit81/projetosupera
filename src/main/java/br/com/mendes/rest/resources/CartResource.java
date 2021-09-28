package br.com.mendes.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mendes.domain.models.CartItem;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;
import br.com.mendes.exception.ResourceNotFoundException;
import br.com.mendes.rest.resources.dto.CartListDTO;
import br.com.mendes.services.CartItemService;
import br.com.mendes.services.CustomerService;
import br.com.mendes.services.ProductService;

@RestController
@RequestMapping("/cart")
public class CartResource {
	
	@Autowired	
	private CustomerService customerService;
	
	@Autowired	
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService prodService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public CartItem create(@RequestBody CartListDTO cartListDTO) {
		
		Customer customerd = cartListDTO.getCustomer();
		Product product = cartListDTO.getProduct();
	
		Customer customerSearch = null;
		Product productSearch = null;
		
		try {
					 
			 customerSearch = customerService.findById(customerd.getId()).get();
			
			 productSearch = prodService.findById(product.getId()).get();
		}catch(ResourceNotFoundException e) {
			
			throw e;
		}
			
		return cartItemService.updateOrSaveProductCustomerOnCartItem(customerSearch, productSearch, 10);
		
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody CartListDTO cartListDTO) {
		Customer customerd = cartListDTO.getCustomer();
		Product product = cartListDTO.getProduct();
	
		Customer customerSearch = null;
		Product productSearch = null;
		
		try {
					 
			 customerSearch = customerService.findById(customerd.getId()).get();
			
			 productSearch = prodService.findById(product.getId()).get();
			
		}catch(ResourceNotFoundException e) {
			
			throw e;
		}
			
		cartItemService.delete(customerSearch, productSearch);
	}

}
