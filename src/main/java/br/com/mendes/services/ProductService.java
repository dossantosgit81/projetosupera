package br.com.mendes.services;

import br.com.mendes.domain.models.Product;



//@Query(value="select customer.id, product.description, product.price, cart_item.freight, cart_item.qtd, cart_item.subtotal from product join cart_item on\r\n"
//		+ "cart_item.product_id = product.id\r\n"
//		+ "join customer on \r\n"
//		+ "customer.id = cart_item.customer_id where customer.id = :cid and product.id = :prodId", nativeQuery=true)
//List<ProductCartItemDTO> resultList( @Param("cid") Long cid, @Param("prodId") Long prodId);
public interface ProductService {
	
	Product save(Product product);
	
}
