package projet.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import projet.spring.entities.Oders;
import projet.spring.services.OrderService;

@RestController

@CrossOrigin("*")
public class OrderController {
@Autowired
OrderService orderservice;

//Affichage
@GetMapping("/Orders")
@ResponseBody
public List<Oders> getAllOrders(){
	List<Oders> list=orderservice.getAllOrders();
	return list;
}

//Ajout
@PostMapping("/AjouterOrder")
@ResponseBody
//Kif yabda aandou barsha paramètres naaml @RequestBody
public Oders AjouterOrder(@RequestBody Oders o) {
	return orderservice.AjouterOrder(o);
}

//Suppression
@DeleteMapping("DeleteOrder/{id}")
@ResponseBody
//Kif yabda aana paramètres barka naaml @PathVariable
public void DeleteOrder(@PathVariable("id") Long id_order) {
	orderservice.DeleteById(id_order);
}

//Modifier 
@PutMapping("/UpdateOrder")
@ResponseBody
public Oders UpdateOrder(@RequestBody Oders o) {
return orderservice.UpdateOrder(o);
		}
	
}
