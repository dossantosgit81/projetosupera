package br.com.mendes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.models.Address;
import br.com.mendes.domain.repositories.AddressRepository;
import br.com.mendes.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

}
