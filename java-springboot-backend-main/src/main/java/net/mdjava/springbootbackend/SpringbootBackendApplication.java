package net.mdjava.springbootbackend;

import net.mdjava.springbootbackend.model.Category;
import net.mdjava.springbootbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }
    
    @Autowired
     private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setProduct("Food");
        category.setClassification("Price of food");
        category.setQuantity(4654.34);
        category.setPayment("Gcash");

        categoryRepository.save(category);
        
      //  Category category1 = new Category();
      //  category1.setProduct("Beverage");
      //  category1.setDescription("Price of beverage");
      //  categoryRepository.save(category1);

      //   Category category3 = new Category();
      //  category3.setProduct("Beverage");
      //  category3.setDescription("Price of beverage");
      //  categoryRepository.save(category3);
    }
}
