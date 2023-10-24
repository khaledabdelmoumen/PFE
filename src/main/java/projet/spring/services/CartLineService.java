package projet.spring.services;

import java.util.List;

import projet.spring.entities.CartLine;

public interface CartLineService {
	CartLine AjouterCartLine(CartLine cL);
	void DeleteCartLine(CartLine c);
	void DeleteCartLineById(Long id_cartLine);
	List<CartLine> getAllCartLine();
}
