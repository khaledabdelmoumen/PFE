package projet.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.spring.entities.Customers;
import projet.spring.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRep;

	@Override
	public Customers AjouterCustomer(Customers c) {
		customerRep.save(c);
		return c;
	}

	@Override
	public void DeleteCustomer(Customers c) {
		customerRep.delete(c);
		
	}

	@Override
	public void DeleteById(Long id_customer) {
		customerRep.deleteById(id_customer);
		
	}

	@Override
	public List<Customers> getAllCustomer() {
		return (List<Customers>) customerRep.findAll();
	}
	
	
}
