package br.com.mendes.services;

import br.com.mendes.domain.models.CartItem;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;

public interface CartItemService {
	
	CartItem save(CartItem cart);
	
	CartItem updateOrSaveProductCustomerOnCartItem(Customer customer, Product product, Integer qtd);
	
	void delete(Customer customer, Product product);
	

}
