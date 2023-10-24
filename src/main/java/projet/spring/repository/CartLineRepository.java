package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.CartLine;

@Repository
public interface CartLineRepository  extends CrudRepository<CartLine, Long>{

}
