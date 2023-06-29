package net.mdjava.springbootbackend;

// import net.mdjava.springbootbackend.model.Category;
// import net.mdjava.springbootbackend.repository.CategoryRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }
    
    // @Autowired
    // private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Category category = new Category();
        // category.setName("Food");
        // category.setDescription("The description of Food");
        // categoryRepository.save(category);
        
        // Category category1 = new Category();
        // category1.setName("Beverage");
        // category1.setDescription("The description of Beverage");
        // categoryRepository.save(category1);
    }
}
