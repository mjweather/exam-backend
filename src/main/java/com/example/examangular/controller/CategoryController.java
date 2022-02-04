package com.example.examangular.controller;

import com.example.examangular.model.exam.Category;
import com.example.examangular.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }
    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
    return this.categoryService.updateCategory(category);
    }
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId")Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }
}
