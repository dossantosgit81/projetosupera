package br.com.mendes.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mendes.domain.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
