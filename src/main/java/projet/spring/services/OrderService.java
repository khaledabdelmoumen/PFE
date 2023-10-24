package projet.spring.services;

import java.util.List;



import projet.spring.entities.Oders;

public interface OrderService {

	Oders AjouterOrder(Oders o);
	void DeleteOrder(Oders o);
	void DeleteById(Long id_order);
	List<Oders> getAllOrders();
	Oders UpdateOrder(Oders o);

}
