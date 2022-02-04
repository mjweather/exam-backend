package com.example.examangular.service.implement;

import com.example.examangular.model.exam.Category;
import com.example.examangular.repo.CategoryRepository;
import com.example.examangular.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long CategoryId) {
        return this.categoryRepository.findById(CategoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category=new Category();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);

    }
}
