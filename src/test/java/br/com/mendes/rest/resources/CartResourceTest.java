package br.com.mendes.rest.resources;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mendes.domain.models.CartItem;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;
import br.com.mendes.services.CartItemService;
import br.com.mendes.services.CustomerService;
import br.com.mendes.services.ProductService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers=CartResource.class)
@AutoConfigureMockMvc
public class CartResourceTest {
	
	private static final String PRODUCT_API = "/products";
	
	 @Autowired
	 MockMvc mvc;
	
	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private ProductService productService;
	
	@MockBean
	private CartItemService cartItemService;	
	
//	@Test
//	@DisplayName("updated cart sucessfull")
//	public void createCartResourceTest() throws JsonProcessingException {
//		
//		Customer serachCustomer = customer();
//		Product savedProduct = product();
//		
//		BDDMockito.given(customerService.findById(Mockito.anyLong())).willReturn(Optional.of(serachCustomer));
//		BDDMockito.given(productService.findById(Mockito.anyLong())).willReturn(Optional.of(savedProduct));
//
//		CartItem savedCartItem = new CartItem(5l, serachCustomer, savedProduct, 10);
//		String json = new ObjectMapper().writeValueAsString(savedCartItem);
//		
//		BDDMockito.given(cartItemService.save(Mockito.any(CartItem.class))).willReturn(savedCartItem);
//		
//		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
//				.patch(PRODUCT_API)
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON)
//				.content(json);
//		
//		mvc.perform(request)
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("id").value(5l))
//		.andExpect(MockMvcResultMatchers.jsonPath("CartItem").value(5l))
//		.andExpect(MockMvcResultMatchers.jsonPath("id").value(5l));
//		
//		
//	}
	
	private Customer customer() {
		//Long id, String name, String email
		Customer customerTeste = new Customer();
		
		customerTeste.setId(5l);
		
		return customerTeste;
	}
	
	private Product product() {
		//Long id, String name, String email
		Product product = new Product();
		
		product.setId(5l);
		
		return product;
	}

}
