package projet.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.spring.entities.CartLine;
import projet.spring.repository.CartLineRepository;

@Service
public class CartLineServiceImpl implements CartLineService{

	@Autowired
	CartLineRepository cartLineRepo;
	
	@Override
	public CartLine AjouterCartLine(CartLine cL) {
		cartLineRepo.save(cL);
		return cL;
	}

	@Override
	public void DeleteCartLine(CartLine c) {
		cartLineRepo.delete(c);
		
	}

	@Override
	public void DeleteCartLineById(Long id_cartLine) {
		cartLineRepo.deleteById(id_cartLine);
		
	}

	@Override
	public List<CartLine> getAllCartLine() {
		return (List<CartLine>) cartLineRepo.findAll();
	}
}
