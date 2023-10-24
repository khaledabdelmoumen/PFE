package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.Customers;

@Repository
public interface CustomerRepository extends CrudRepository<Customers,Long> {

}
