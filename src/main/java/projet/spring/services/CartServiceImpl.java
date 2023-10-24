package projet.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.spring.entities.Cart;
import projet.spring.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepo;

	@Override
	public Cart AjouterCart(Cart c) {
		cartRepo.save(c);
		return c;
	}

	@Override
	public void DeleteCart(Cart c) {
		cartRepo.delete(c);
		
	}

	@Override
	public void DeleteCartById(Long id_cart) {
		cartRepo.deleteById(id_cart);
		
	}

	@Override
	public List<Cart> getAllCart() {
		return (List<Cart>) cartRepo.findAll();
	}
 
}
