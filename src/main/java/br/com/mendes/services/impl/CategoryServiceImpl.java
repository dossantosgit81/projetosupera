package br.com.mendes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.domain.models.Category;
import br.com.mendes.domain.repositories.CategoryRepository;
import br.com.mendes.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		
		return categoryRepository.save(category);
	}

}
