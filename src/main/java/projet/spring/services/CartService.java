package projet.spring.services;

import java.util.List;

import projet.spring.entities.Cart;

public interface CartService {
	Cart AjouterCart(Cart c);
	void DeleteCart(Cart c);
	void DeleteCartById(Long id_cart);
	List<Cart> getAllCart();
}
