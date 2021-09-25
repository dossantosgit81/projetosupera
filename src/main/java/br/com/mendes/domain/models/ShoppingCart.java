package br.com.mendes.domain.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	
	@Id
	@Column(unique=true)
	private Long id;
	
	private BigDecimal subtotal;
	
	private BigDecimal freight;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public ShoppingCart() {
	}

	public ShoppingCart(Customer id, Customer customer) {
		this.id = id.getId();
		this.customer = customer;
	}

	@OneToMany
	@JoinTable(name="carts_products",
		joinColumns = @JoinColumn(name="cart_id", referencedColumnName="id", table="shopping_cart"),
		inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName="id", table="product")
			)
	private Set<Product> itens = new HashSet<>();

	public BigDecimal getSubtotal() {
		setCalcSubtotal();
		return subtotal;
	}

	public BigDecimal getFreight() {
		setCalcFreight();
		return freight;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Product> getItens() {
		return itens;
	}

	public void setItens(Set<Product> itens) {
		this.itens = itens;
	}
	
	private void setCalcSubtotal() {
		if(subtotal == null) {
			subtotal = new BigDecimal("0.0");
		}
		
		if(itens.size() > 0) {			
			itens.forEach(el ->{
					subtotal = subtotal.add(el.getPrice());
					
			});
		}
	}
	
	private void setCalcFreight() {
		if (freight == null) {
			freight = new BigDecimal("0.0");
		}
		
		if(itens.size() > 0) {
			itens.forEach(el -> {	
				freight = freight.add(new BigDecimal("10.0"));
			});
		}
	}
}
