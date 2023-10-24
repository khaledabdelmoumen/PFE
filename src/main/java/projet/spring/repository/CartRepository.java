package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.Cart;
import projet.spring.entities.CartLine;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}
