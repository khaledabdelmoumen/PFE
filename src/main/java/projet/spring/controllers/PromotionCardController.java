package projet.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projet.spring.entities.PromotionCard;
import projet.spring.services.PromotionCardService;

@RestController
@CrossOrigin("*")
public class PromotionCardController {
	@Autowired
	PromotionCardService promotionCardService;
	
	@GetMapping("/promotionCards")
	@ResponseBody
	public List<PromotionCard> getAllPromotionCards(){
		
		List<PromotionCard> list = promotionCardService.getAllPromotionCards();
		return list;
	}
 
	
	
	@PostMapping("/addPromotionCard")
	@ResponseBody
	public PromotionCard AjouterPromotionCard(@RequestBody PromotionCard promoCard) {
		return promotionCardService.AjouterPromotionCard(promoCard);
	}
	
	@DeleteMapping("/deletePromotionCardById/{id}")
	@ResponseBody
	public void DeletePromotionCard(@PathVariable("id") Long idPromoCard) {
		promotionCardService.DeletePromotionCard(idPromoCard);
	}
}
