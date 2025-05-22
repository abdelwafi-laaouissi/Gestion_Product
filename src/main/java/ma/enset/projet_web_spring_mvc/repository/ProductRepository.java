package ma.enset.projet_web_spring_mvc.repository;

import ma.enset.projet_web_spring_mvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
