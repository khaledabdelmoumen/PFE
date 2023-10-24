package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{

}
