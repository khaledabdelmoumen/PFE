package projet.spring.services;

import java.util.List;

import projet.spring.entities.PromotionCard;

public interface PromotionCardService {
	PromotionCard AjouterPromotionCard(PromotionCard promotion);
	void DeletePromotionCard (PromotionCard promotion);
	void DeletePromotionCard (Long id);
	List<PromotionCard> getAllPromotionCards();
}
