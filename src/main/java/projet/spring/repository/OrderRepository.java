package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.Oders;

@Repository
public interface OrderRepository extends CrudRepository<Oders,Long>{

}
