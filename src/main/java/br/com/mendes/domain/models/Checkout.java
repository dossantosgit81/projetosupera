package br.com.mendes.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.mendes.domain.models.enums.StatusSale;

@Entity
public class Checkout {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="date_sale")
	private LocalDate dateSale;
	
	@Column(name="total_sale")
	private BigDecimal totalSale;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private StatusSale status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateSale() {
		return dateSale;
	}

	public void setDateSale(LocalDate dateSale) {
		this.dateSale = dateSale;
	}

	public BigDecimal getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(BigDecimal totalSale) {
		this.totalSale = totalSale;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StatusSale getStatus() {
		return status;
	}

	public void setStatusSale(StatusSale status) {
		this.status = status;
	}
	
	

}
