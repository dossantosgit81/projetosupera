package br.com.mendes.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mendes.domain.models.Product;

@Repository
public interface TesteRepository extends JpaRepository<Product, Long> {
	
	@Query(value="select product.description, product.price, cart_item.freight, cart_item.qtd, cart_item.subtotal from product join cart_item on cart_item.product_id = product.id\r\n"
			+ "			 join customer on \r\n"
			+ "			 customer.id = cart_item.customer_id\r\n"
			+ "			 join category on\r\n"
			+ "			category.id = product.category_id\r\n"
			+ " where customer.id = 1 and product.id = 1", nativeQuery=true)
	 List<Product> resultList(@Param("cid") Long cid, @Param("prodId") Long prodId);
	
	/*
	 * select product.description, product.price, cart_item.freight, cart_item.qtd, cart_item.subtotal from product join cart_item on cart_item.product_id = product.id
			 join customer on 
			 customer.id = cart_item.customer_id
			 join category on
			category.id = product.category_id
 where customer.id = 1 and product.id = 1
	 * */

}
