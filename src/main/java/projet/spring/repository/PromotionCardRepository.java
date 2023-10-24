package projet.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.spring.entities.PromotionCard;

@Repository
public interface PromotionCardRepository extends CrudRepository<PromotionCard, Long>{

}
