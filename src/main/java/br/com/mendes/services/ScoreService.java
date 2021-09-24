package br.com.mendes.services;

import org.springframework.stereotype.Repository;

import br.com.mendes.domain.models.Score;

@Repository
public interface ScoreService {

	Score save(Score score);
	
}
