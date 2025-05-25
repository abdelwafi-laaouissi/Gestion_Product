package ma.enset.projet_web_spring_mvc.repository;

import ma.enset.projet_web_spring_mvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String keyword);
}
