package br.com.mendes.domain.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Score implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	ScorePk id = new ScorePk();
	
	private BigDecimal score;
	
	public Score() {
		
	}

	public Score(Product product, Customer customer, BigDecimal score) {
		id.setProduct(product);
		id.setCustomer(customer);
		this.score = score;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public ScorePk getId() {
		return id;
	}

	public void setSocreFk(ScorePk id) {
		this.id = id;
	}
	
	
	
	
}
