package br.com.mendes;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mendes.domain.models.Address;
import br.com.mendes.domain.models.CartItem;
import br.com.mendes.domain.models.Category;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;
import br.com.mendes.domain.models.Score;
import br.com.mendes.services.AddressService;
import br.com.mendes.services.CartItemService;
import br.com.mendes.services.CategoryService;
import br.com.mendes.services.CustomerService;
import br.com.mendes.services.ProductService;
import br.com.mendes.services.ScoreService;


@SpringBootApplication
public class ProjetosuperaApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ScoreService scocreService;
	
	@Autowired
	private CartItemService cis;
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetosuperaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer1 = customerService.save(new Customer(null, "Rafael Mendes dos Santos", "dossantosgit@gmail.com"));
		Customer customer2 = customerService.save(new Customer(null, "João da Silva", "João@hotmail.com"));
		Customer customer3 = customerService.save(new Customer(null, "João da Silva", "João@hotmail.com"));
		
		Address address1 = new Address(null, "Brasil", "BA", "Barreiras", "Morada da Lua", "Rua da feira", "44a", customer1);
		Address address2 = new Address(null, "Brasil", "BA", "Barreiras", "Sandra Regina", "Rua da feira", "36b", customer1);
		Address address3 = new Address(null, "Brasil", "BA", "São Paulo", "Sandra Regina", "Rua da feira", "36b", customer2);
		
		addressService.save(address1);
		addressService.save(address2);
		addressService.save(address3);
		
		System.out.println("Endereços e e cliente cadastrado");
		
		Category category1 = categoryService.save(new Category(null, "Esporte"));
		Category category2 = categoryService.save(new Category(null, "Final fantasy"));
		
		Product prod1 = productService.save(new Product(null, "Fifa Mobile", new BigDecimal("20"), category1));
		Product prod2 = productService.save(new Product(null, "Clash Royale", new BigDecimal("10"), category2));
		
		Score score1 = new Score(prod1, customer1, new BigDecimal("3"));
		Score score2 = new Score(prod1, customer2, new BigDecimal("2"));
		Score score3 = new Score(prod2, customer1, new BigDecimal("5"));
		Score score4 = new Score(prod2, customer1, new BigDecimal("5"));

		scocreService.save(score1);
		scocreService.save(score2);
		scocreService.save(score3);
		scocreService.save(score4);
		
		//Customer customer, Integer qtd, Product product
		
		CartItem cartItem1 = new CartItem(null, customer1, prod1, 5);
		CartItem cartItem2 = new CartItem(null, customer2, prod2, 5);
		CartItem cartItem3 = new CartItem(null, customer3, prod2, 5);
		//CartItem cartItem3 = new CartItem(customer, prod1, 2);
		
		cis.save(cartItem1);
		cis.save(cartItem2);
		cis.save(cartItem3);
		
		System.out.println(cis.updateOrSaveProductCustomerOnCartItem(customer1, prod1, 10));
		System.out.println(cis.updateOrSaveProductCustomerOnCartItem(customer2, prod2, 10));
		System.out.println(cis.updateOrSaveProductCustomerOnCartItem(customer3, prod2, 10));
		
		System.out.println(cis.updateOrSaveProductCustomerOnCartItem(customer1, prod2, 10));
		System.out.println(cis.updateOrSaveProductCustomerOnCartItem(customer2, prod1, 10));
		System.out.println(cis.updateOrSaveProductCustomerOnCartItem(customer3, prod1, 10));
		
		cis.delete(customer3, prod1);
		
		System.out.println("Fim!!!!!");
		
		
		//Já existe um produto cadastrado com esse id e cliente
		
	}

}
