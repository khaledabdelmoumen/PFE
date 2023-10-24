package projet.spring.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.param.checkout.SessionCreateParams;


@Component

public class StripeClient {

    @Autowired
    StripeClient() {
    	Stripe.apiKey = "sk_test_51O0LtuGtysKsBEgW0yxPUaPvYExsNNOm4FWs8WPxzUnPSYYi26hAbaRj3mAzTx1NKLKsVilcd40jQM5UPhRcqtYh00T2CCOKaz";
    }

    
   
    public Charge chargeCreditCard(String token, double amount) throws Exception {
    	Map <String, Object> chargeParams = new HashMap<String, Object>();
    	SessionCreateParams params =
    			  SessionCreateParams.builder()
    			    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
    			    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.PAYPAL)
    			    .addLineItem(
    			      SessionCreateParams.LineItem.builder()
    			        .setPriceData(
    			          SessionCreateParams.LineItem.PriceData.builder()
    			            .setCurrency("usd")
    			            .setUnitAmount(2000L)
    			            .setProductData(
    			              SessionCreateParams.LineItem.PriceData.ProductData.builder()
    			                .setName("T-shirt")
    			                .build())
    			            .build())
    			        .setQuantity(1L)
    			        .build())
    			    .setMode(SessionCreateParams.Mode.PAYMENT)
    			    .setSuccessUrl("https://example.com/success")
    			    .setCancelUrl("https://example.com/cancel")
    			    .build();

    			
        chargeParams.put("amount", (int)(amount));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);
       Charge charge = Charge.create(chargeParams);
        return charge;
    }
}