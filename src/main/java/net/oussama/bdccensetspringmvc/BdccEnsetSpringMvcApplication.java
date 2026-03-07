package net.oussama.bdccensetspringmvc;

import net.oussama.bdccensetspringmvc.entities.Product;
import net.oussama.bdccensetspringmvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication(exclude ={SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class BdccEnsetSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdccEnsetSpringMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner  start(ProductRepository productRepository){
        return args->{
            productRepository.save(Product.builder()
                            .name("Printer")
                            .price(1220)
                            .quantity(11)
                            .build());
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(5400)
                    .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                    .name("SmartPhone")
                    .price(12000)
                    .quantity(40)
                    .build());
            productRepository.findAll().forEach(product -> {
                System.out.println(product.toString());
            });
        };

    }

}
