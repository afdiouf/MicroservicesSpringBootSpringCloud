package sn.dioufy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
		return args->{
			repositoryRestConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null, "Ordi DELL Pro 15500", Math.random()*1000));
			productRepository.save(new Product(null, "Ordi HP EliteBook Pro", Math.random()*1000));
			productRepository.save(new Product(null, "Ordi MAC BOOK Pro", Math.random()*1000));
			productRepository.findAll().forEach(System.out::println);
		};
	}

}

@Entity 
@Data 
@AllArgsConstructor @NoArgsConstructor @ToString
class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
}

@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product, Long> {}
