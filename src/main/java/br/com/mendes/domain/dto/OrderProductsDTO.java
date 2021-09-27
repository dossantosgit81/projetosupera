package br.com.mendes.domain.dto;

import java.math.BigDecimal;

public class OrderProductsDTO {
	
	private Long id;
	
	private String description;
	
	private BigDecimal price;
	
	private String nameCategory;
	
	private BigDecimal score;
	
	public OrderProductsDTO() {
	}

	public OrderProductsDTO(Long id, String description, BigDecimal price, String nameCategory, BigDecimal score) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.nameCategory = nameCategory;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ProductOrderByPriceDTO [id=" + id + ", description=" + description + ", price=" + price
				+ ", nameCategory=" + nameCategory + "]";
	}
	
	

}
