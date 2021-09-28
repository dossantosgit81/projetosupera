package br.com.mendes.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.repositories.CustomerRepository;
import br.com.mendes.exception.ResourceNotFoundException;
import br.com.mendes.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> findById(Long id)  {
		
		Optional<Customer> searachEdCustomer = customerRepository.findById(id);
		
		if(searachEdCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Cliente não encontrado");
		}
		
		return searachEdCustomer;
	}

}
