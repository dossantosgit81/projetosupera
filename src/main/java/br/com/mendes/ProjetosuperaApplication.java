package br.com.mendes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mendes.domain.models.Address;
import br.com.mendes.domain.models.Customer;
import br.com.mendes.services.AddressService;
import br.com.mendes.services.CustomerService;

@SpringBootApplication
public class ProjetosuperaApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;

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
		
		
		
		
		
	}

}
