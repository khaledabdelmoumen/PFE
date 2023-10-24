package projet.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import projet.spring.entities.Product;
import projet.spring.services.ProductService;

@RequestMapping("Product")
@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	
		@PostMapping("/AddProduct")
		@ResponseBody
		public Product AjouterProduct(@RequestBody Product p) {
			return ps.AddProduct(p);
		}

		
}
