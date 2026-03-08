package net.oussama.bdccensetspringmvc.repository;

import net.oussama.bdccensetspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product,Long> {

}
