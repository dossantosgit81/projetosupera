package br.com.mendes.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mendes.domain.models.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	
	
}
