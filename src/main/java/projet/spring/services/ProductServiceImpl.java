package projet.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.spring.entities.Product;
import projet.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository pr ;

	@Override
	public Product AddProduct(Product p) {
		
	pr.save(p);
			
	return p ;
		 
	}
	
	
	
	

}
