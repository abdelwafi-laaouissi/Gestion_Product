package ma.enset.projet_web_spring_mvc;

import ma.enset.projet_web_spring_mvc.entities.Product;
import ma.enset.projet_web_spring_mvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProjetWebSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetWebSpringMvcApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                            .name("Product-1")
                            .price(5400)
                            .quantity(22)
                            .build());
            productRepository.save(Product.builder()
                            .name("Product-2")
                            .price(555)
                            .quantity(5)
                            .build());
            productRepository.save(Product.builder()
                            .name("Product-3")
                            .price(1000)
                            .quantity(63)
                            .build());
            productRepository.save(Product.builder()
                            .name("Product-4")
                            .price(1245)
                            .quantity(37)
                            .build());
            productRepository.findAll().forEach(p ->{
                System.out.println(p.toString());
            });
        };
    }

}
