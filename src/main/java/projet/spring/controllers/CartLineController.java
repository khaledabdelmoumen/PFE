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

import projet.spring.entities.CartLine;
import projet.spring.services.CartLineService;

@RestController
@CrossOrigin("*")
public class CartLineController {

	@Autowired
	CartLineService cartlineservice;
	

	//Affichage
	@GetMapping("/CartLines")
	@ResponseBody
	public List<CartLine> getAllCartLines(){
		List<CartLine> list=cartlineservice.getAllCartLine();
		return list;
	}

	//Ajout
	@PostMapping("/AjouterCartLine")
	@ResponseBody
	//Kif yabda aandou barsha paramètres naaml @RequestBody
	public CartLine AjouterCartLine(@RequestBody CartLine c) {
		return cartlineservice.AjouterCartLine(c);
	}

	//Suppression
	@DeleteMapping("DeleteCartLine/{id}")
	@ResponseBody
	//Kif yabda aana paramètres barka naaml @PathVariable
	public void DeleteCartLine(@PathVariable("id") Long id_cart) {
		cartlineservice.DeleteCartLineById(id_cart);
	}
	
	
}
