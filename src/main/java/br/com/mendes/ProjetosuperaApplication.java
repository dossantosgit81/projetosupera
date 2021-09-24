package br.com.mendes;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mendes.domain.models.Address;
import br.com.mendes.domain.models.Category;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;
import br.com.mendes.services.AddressService;
import br.com.mendes.services.CategoryService;
import br.com.mendes.services.CustomerService;
import br.com.mendes.services.ProductService;

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

	public static void main(String[] args) {
		SpringApplication.run(ProjetosuperaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer1 = customerService.save(new Customer(null, "Rafael Mendes dos Santos", "dossantosgit@gmail.com"));
		Customer customer2 = customerService.save(new Customer(null, "João da Silva", "João@hotmail.com"));
		
		Address address1 = new Address(null, "Brasil", "BA", "Barreiras", "Morada da Lua", "Rua da feira", "44a", customer1);
		Address address2 = new Address(null, "Brasil", "BA", "Barreiras", "Sandra Regina", "Rua da feira", "36b", customer1);
		Address address3 = new Address(null, "Brasil", "BA", "São Paulo", "Sandra Regina", "Rua da feira", "36b", customer2);
		
		addressService.save(address1);
		addressService.save(address2);
		addressService.save(address3);
		
		System.out.println("Endereços e e cliente cadastrado");
		
		//Long id, String description, BigDecimal price, Integer qtdStock
		//Long id, String name
		
		Category category1 = categoryService.save(new Category(null, "Esporte"));
		Category category2 = categoryService.save(new Category(null, "Final fantasy"));
		
		Product prod1 = productService.save(new Product(null, "Fifa Mobile", new BigDecimal("26.80"), 3, category1));
		Product prod2 = productService.save(new Product(null, "Clash Royale", new BigDecimal("20.91"), 3, category2));
		Product prod3 = productService.save(new Product(null, "Pes Mobile", new BigDecimal("11.76"), 3, category1));
		
		
		category1.getProducts().addAll(Arrays.asList(prod1, prod2));
		category2.getProducts().add(prod3);
		
		for(Product product : category1.getProducts()) {
			System.out.println(product);
		}
		
		for(Product product : category2.getProducts()) {
			System.out.println(product);
		}
		
		
		//relação entre Prod1 e Customer
		
	}

}
