package br.com.mendes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.repositories.CustomerRepository;
import br.com.mendes.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		//TO-DO Validar se email já existe
		return customerRepository.save(customer);
	}

}
