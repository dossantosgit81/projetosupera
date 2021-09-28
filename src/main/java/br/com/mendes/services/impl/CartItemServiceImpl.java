package br.com.mendes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.domain.dto.CartItemProductDTO;
import br.com.mendes.domain.models.CartItem;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;
import br.com.mendes.domain.repositories.CartItemRepository;
import br.com.mendes.domain.repositories.jdbcutils.JDBCUtilRepository;
import br.com.mendes.services.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartRepository;

	@Autowired
	private JDBCUtilRepository jdbcUtilRepository;


	@Override
	public CartItem save(CartItem item) {
		
		return cartRepository.save(item);
	}
	
	@Transactional
	public CartItem updateOrSaveProductCustomerOnCartItem(Customer customer, Product product, Integer qtd) {
		
		try {
			
			List<CartItemProductDTO> resultList = resultListCartItem(customer, product);	

			CartItemProductDTO result = resultList.get(0);
			Optional <CartItem> cartItem = cartRepository.findById(result.getId());
			cartItem.get().CalcFreightSubtotal(result.getQtd() + qtd);
			
			return cartRepository.save(cartItem.get());
			
		}catch(EmptyResultDataAccessException e) {
			
			return cartRepository.save(new CartItem(null, customer, product, qtd));
		}

	}


	@Transactional
	@Override
	public void delete(Customer customer, Product product) {
		try {
			Long idCartItem = resultListCartItem( customer, product).get(0).getId();
			
			cartRepository.deleteById(idCartItem);
			
			System.out.println("Fim program!!");
			
		}catch(EmptyResultDataAccessException e) {
			System.out.println("Produto inexistente");
			e.printStackTrace();
		}
		
	}
	
	
	

	private List<CartItemProductDTO> resultListCartItem(Customer customer, Product product) {
		return jdbcUtilRepository.searchCartItemProductDTO(customer.getId(), product.getId());
	}






}
