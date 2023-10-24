import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { loadStripe } from '@stripe/stripe-js';
import { environment } from 'src/environments/environment';
  

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
 
  constructor(private http: HttpClient) { }
cvc="123";
expYear="2025"
expMonth="07"
cardNumber="4242424242424242"
  ngOnInit(): void {
  }
  chargeCreditCard() {
    console.log(this.cvc,this.expMonth,this.cardNumber);
    (<any>window).Stripe.card.createToken({
      number: this.cardNumber,
      exp_month: this.expMonth,
      exp_year:this.expYear,
      cvc: this.cvc
    }, (status: number, response: any) => {
      if (status === 200) {
        let token = response.id;
        this.chargeCard(token);
      } else {
        console.log(response.error.message);
      }
    });
  }


  chargeCard(token: string) {
    const headers = new HttpHeaders({'token': token, 'amount': '500'});
    this.http.post<any>('http://localhost:8081/payment/charge', {}, {headers: headers})
    .subscribe(
      response => {
        const message = response['message'];
        console.log(message);
      },
      error => {
        console.error(error);
      }
    )
  }
  
}


