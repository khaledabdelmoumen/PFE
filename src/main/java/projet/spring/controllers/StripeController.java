package projet.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stripe.Stripe;
import com.stripe.model.Charge;

import jakarta.servlet.http.HttpServletRequest;
import projet.spring.components.StripeClient;

@RestController
@RequestMapping(value = "/payment")
@CrossOrigin("*") 


public class StripeController {
	StripeClient stripeClient;
	

	StripeController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }
	

	 @PostMapping("/charge")
	    public ResponseEntity<String> chargeCard(HttpServletRequest request) throws Exception {
	        String token = request.getHeader("token");
	        Double amount = Double.parseDouble(request.getHeader("amount"));
	        Charge charge = this.stripeClient.chargeCreditCard(token, amount);

	        // Handle the charge response
	        if (charge.getPaid()) {
	            return ResponseEntity.ok("{\"message\": \"Payment successful\"}");
	        } else {
	            return ResponseEntity.ok("{\"message\": \"Payment failed\"}");
	        }
	    }
	

}
