package ma.enset.projet_web_spring_mvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Product {
    @Id @GeneratedValue
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 30)
    private String name;
    @Min(value = 0)
    private  double price;
    @Min(value = 1)
    private double quantity;
}
