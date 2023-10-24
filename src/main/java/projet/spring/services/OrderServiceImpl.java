package projet.spring.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.spring.entities.Oders;
import projet.spring.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderRepository RepOrder;

	@Override
	public Oders AjouterOrder(Oders o) {
		 LocalDateTime localDateTime = LocalDateTime.now();
	   o.setCreationDate(Timestamp.valueOf(localDateTime));  
		 
		return  RepOrder.save(o) ;
	}

	@Override
	public void DeleteOrder(Oders o) {
		RepOrder.delete(o);
		
	}

	@Override
	public void DeleteById(Long id_order) {
		RepOrder.deleteById(id_order);
	}

	@Override
	public List<Oders> getAllOrders() {
		// TODO Auto-generated method stub
		return (List<Oders>) RepOrder.findAll();
	}
	
	@Override
	public Oders UpdateOrder(Oders o) {
		// TODO Auto-generated method stub
		return RepOrder.save(o);
	}
}
