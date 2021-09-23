package br.com.mendes;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mendes.domain.models.Address;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.domain.models.Product;
import br.com.mendes.services.AddressService;
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

	public static void main(String[] args) {
		SpringApplication.run(ProjetosuperaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Customer customer = new Customer(null, "Rafael Mendes dos Santos", "dossantosgit@gmail.com");
		Customer savedCustomer = customerService.save(customer);
		
		Address address = new Address(null, "Brasil", "BA", "Barreiras", "Morada da Lua", "Rua da feira", "44a", savedCustomer);
		
		addressService.save(address);
		
		System.out.println("Endereços e e cliente cadastrado");
		
		//Long id, String description, BigDecimal price, Integer qtdStock
		Product prod1 = new Product(null, "Fifa Mobile", new BigDecimal("26.80"));
		Product prod2 = new Product(null, "Pes Mobile", new BigDecimal("19.80"));
		Product prod3 = new Product(null, "Clash Royale", new BigDecimal("10.80"));
		
		productService.save(prod1);
		productService.save(prod2);
		productService.save(prod3);
	}

}
