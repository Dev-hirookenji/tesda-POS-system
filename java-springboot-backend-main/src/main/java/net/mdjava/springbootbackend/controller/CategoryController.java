/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mdjava.springbootbackend.controller;

import net.mdjava.springbootbackend.model.Category;
import net.mdjava.springbootbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import net.mdjava.springbootbackend.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author eMDi
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    // build create category REST API
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
    
    // build get category by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id: " + id));
        return ResponseEntity.ok(category);
    }
    
    // build update category REST API
    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category categoryDetails) {
        Category updateCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id: " + id));
        
        updateCategory.setName(categoryDetails.getName());
        updateCategory.setDescription(categoryDetails.getDescription());
        
        categoryRepository.save(updateCategory);
        
        return ResponseEntity.ok(updateCategory);
    }
    
    // build delete category REST API
    @DeleteMapping("{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id: " + id));
        
        categoryRepository.delete(category);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
