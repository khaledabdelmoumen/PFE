package projet.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
