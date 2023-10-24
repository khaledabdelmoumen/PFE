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

import projet.spring.entities.Cart;
import projet.spring.services.CartService;

@RestController
@CrossOrigin("*")
public class CartController {

@Autowired
CartService cartservice;


//Affichage
@GetMapping("/Carts")
@ResponseBody
public List<Cart> getAllCarts(){
	List<Cart> list=cartservice.getAllCart();
	return list;
}

//Ajout
@PostMapping("/AjouterCart")
@ResponseBody
//Kif yabda aandou barsha paramètres naaml @RequestBody
public Cart AjouterCart(@RequestBody Cart c) {
	return cartservice.AjouterCart(c);
}

//Suppression
@DeleteMapping("DeleteCart/{id}")
@ResponseBody
//Kif yabda aana paramètres barka naaml @PathVariable
public void DeleteCart(@PathVariable("id") Long id_cart) {
	cartservice.DeleteCartById(id_cart);
}
}
