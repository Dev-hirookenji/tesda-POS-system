/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.mdjava.springbootbackend.repository;

import net.mdjava.springbootbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

/**
 *
 * @author eMDi
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    // all crud database methods
    
}
