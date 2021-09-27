package br.com.mendes.domain.repositories.jdbcutils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mendes.domain.dto.CartItemProductDTO;

@Repository
public class CartItemProductRepositoryUtil {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@SuppressWarnings("deprecation")
	public List<CartItemProductDTO> searchCartItemProductDTO(Long cid, Long prodId) {
		
		List<CartItemProductDTO> list = new ArrayList<>();
		
		CartItemProductDTO teste = jdbcTemplate.queryForObject("select cart_item.id, product.description, product.price, cart_item.freight, cart_item.qtd, cart_item.subtotal from product join cart_item on cart_item.product_id = product.id\r\n"
				+ "			 join customer on \r\n"
				+ "			 customer.id = cart_item.customer_id\r\n"
				+ " where customer.id = ? and product.id = ?", new Object[] {cid,prodId },
				//String description, BigDecimal price, BigDecimal freight, BigDecimal qtd, BigDecimal subtotal
					(rs, rowNum) -> new CartItemProductDTO(
							rs.getLong("id"),
							rs.getString("description"), 
							rs.getBigDecimal("price"),
							rs.getBigDecimal("freight"),
							rs.getInt("qtd"),
							rs.getBigDecimal("subtotal"))
				);
		 
			list.add(teste);
		 
		return list;
		
	}
	
	

}
