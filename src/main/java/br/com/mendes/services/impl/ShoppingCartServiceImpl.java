package br.com.mendes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.models.ShoppingCart;
import br.com.mendes.domain.repositories.ShoppingCartRepository;
import br.com.mendes.services.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	private ShoppingCartRepository cartRepository;

	@Override
	public ShoppingCart save(ShoppingCart shoppingCart) {
		
		return cartRepository.save(shoppingCart);
	}

}
