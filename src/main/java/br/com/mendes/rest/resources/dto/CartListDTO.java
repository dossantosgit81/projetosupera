package br.com.mendes.rest.resources.dto;

import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;

public class CartListDTO {
	
	private Customer customer;
	
	private Product product;
	
	public CartListDTO() {
		
	}

	public CartListDTO(Customer customer, Product product) {
		this.customer = customer;
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartListDTO [customer=" + customer + ", product=" + product + "]";
	}
	
	

}
