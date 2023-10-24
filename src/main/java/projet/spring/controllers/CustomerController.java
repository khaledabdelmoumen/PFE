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

import projet.spring.entities.Customers;
import projet.spring.services.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	CustomerService customerservice;
	

	//Affichage
	@GetMapping("/Customers")
	@ResponseBody
	public List<Customers> getAllOrders(){
		List<Customers> list=customerservice.getAllCustomer();
		return list;
	}

	//Ajout
	@PostMapping("/AjouterCustomer")
	@ResponseBody
	//Kif yabda aandou barsha paramètres naaml @RequestBody
	public Customers AjouterCustomer(@RequestBody Customers c) {
		return customerservice.AjouterCustomer(c);
	}

	//Suppression
	@DeleteMapping("DeleteCustomer/{id}")
	@ResponseBody
	//Kif yabda aana paramètres barka naaml @PathVariable
	public void DeleteOrder(@PathVariable("id") Long id_customer) {
		customerservice.DeleteById(id_customer);
	}

}
