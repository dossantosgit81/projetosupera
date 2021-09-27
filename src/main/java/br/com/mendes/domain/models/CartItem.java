package br.com.mendes.domain.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_item")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer qtd;
	
	private BigDecimal subtotal;
	
	private BigDecimal freight;
	
	private BigDecimal total;
	
	@OneToOne
	private Product product;
	
	@OneToOne
	private Customer customer;
	
	public CartItem() {
		
	}
	
	public CartItem(Long id, Customer customer, Product product, Integer qtd) {
		this.id = id;
		this.product = product;
		this.qtd = qtd;
		this.subtotal = setSubtotal();
		this.freight = setFreight();
		this.customer= customer;
		this.total = this.subtotal.add(this.freight);
	}
	
	public Long getId() {
		return id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void CalcFreightSubtotal(Integer qtd) {
		this.qtd = qtd;
		this.subtotal = this.setSubtotal();
		
		this.freight = this.setFreight();
		
		this.total = this.subtotal.add(this.freight);
	}
	
	private BigDecimal setFreight() {
		
		if (subtotal.doubleValue() >= 250) {
			
			return new BigDecimal(0.0);
		}
		
		return new BigDecimal(qtd).multiply(new BigDecimal(10));
	}
	
	private BigDecimal setSubtotal() {
		
		return product.getPrice().multiply(new BigDecimal(qtd));
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", qtd=" + qtd + ", subtotal=" + subtotal + ", freight=" + freight + ", product="
				+ product + "]";
	}
	
	

}
