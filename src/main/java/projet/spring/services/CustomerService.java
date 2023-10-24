package projet.spring.services;

import java.util.List;

import projet.spring.entities.Customers;



public interface CustomerService {
	Customers AjouterCustomer(Customers c);
	void DeleteCustomer(Customers c);
	void DeleteById(Long id_customer);
	List<Customers> getAllCustomer();
	

}
