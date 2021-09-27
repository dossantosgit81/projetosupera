package br.com.mendes.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mendes.domain.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value="select * from product order by price desc", nativeQuery=true)
	List<Product> findProductsOrderByPrice();

}
