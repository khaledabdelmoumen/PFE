package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import projet.spring.entities.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Long>{

}
