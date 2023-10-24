package projet.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.spring.entities.PromotionCard;
import projet.spring.repository.PromotionCardRepository;

@Service
public class PromotionCardImpl implements PromotionCardService{
	@Autowired
	PromotionCardRepository PromoCardRep;

	@Override
	public PromotionCard AjouterPromotionCard(PromotionCard promotion) {
		PromoCardRep.save(promotion);
		return promotion;
	}

	@Override
	public void DeletePromotionCard(PromotionCard promotion) {
		PromoCardRep.delete(promotion);
		
	}

	@Override
	public void DeletePromotionCard(Long id) {
		PromoCardRep.deleteById(id);
		
	}

	@Override
	public List<PromotionCard> getAllPromotionCards() {
		return (List<PromotionCard>) PromoCardRep.findAll();
	}
}
