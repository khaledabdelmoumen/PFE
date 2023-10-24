package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog,Long>{

}
