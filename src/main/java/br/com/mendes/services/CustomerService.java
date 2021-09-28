package br.com.mendes.services;

import java.util.Optional;

import br.com.mendes.domain.models.Customer;

public interface CustomerService {
	
	Customer save(Customer customer);
	
	Optional<Customer> findById(Long id);

}
