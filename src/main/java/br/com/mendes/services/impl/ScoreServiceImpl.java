package br.com.mendes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.models.Score;
import br.com.mendes.domain.repositories.ScoreRepository;
import br.com.mendes.services.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreRepository scoreRepository;

	@Override
	public Score save(Score score) {
		
		return scoreRepository.save(score);
	}

}
