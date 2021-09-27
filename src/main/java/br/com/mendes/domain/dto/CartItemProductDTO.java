package br.com.mendes.domain.dto;

import java.math.BigDecimal;

public class CartItemProductDTO {
	
	private Long id;
	
	private String description;
	
	private BigDecimal price;
	
	private BigDecimal freight;
	
	private Integer qtd;
	
	private BigDecimal subtotal;

	public CartItemProductDTO() {
	
	}

	public CartItemProductDTO(Long id, String description, BigDecimal price, BigDecimal freight, Integer qtd, BigDecimal subtotal) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.freight = freight;
		this.qtd = qtd;
		this.subtotal = subtotal;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
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

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Teste [description=" + description + ", price=" + price + ", freight=" + freight + ", qtd=" + qtd
				+ ", subtotal=" + subtotal + "]";
	}
	
	

}
