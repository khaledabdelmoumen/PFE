import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
    

  


  productName!: string ;
  productPrice!: number ;
  quantity!: number ;
  subTotal : number = 0
  total : number = 0
  buttonDecreaseClicked: boolean = false;
  buttonIncreaseClicked: boolean = false;
  isShipToDifferentAddress: boolean = false;
  produits: any[] = [];
  paymentForm: FormGroup;
  showCreditCardLogos: boolean = false;
  receivedData: string = '';

  constructor(private http: HttpClient,private elementRef: ElementRef,private formBuilder: FormBuilder,
    private route: ActivatedRoute) { 
    this.paymentForm = this.formBuilder.group({
    paymentMethod: ['']
  });}

  cvc="";;
  expYear="";
  expMonth="";
  cardNumber="";


  
  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.productName = params['productName'];
      this.productPrice = params['productPrice'];
      this.quantity = params['quantity'];
      this.receivedData = `${this.productName} - ${this.productPrice} - ${this.quantity}`;
    });
    console.log('receivedData', this.receivedData); 
    const nouveauProduit = {
      productName: this.productName,
      productPrice: this.productPrice,
      quantity: this.quantity,
      subTotal: this.productPrice * this.quantity // Calcul du sous-total en fonction du prix et de la quantité
    };
  
    this.produits.push(nouveauProduit);

    this.subTotal = this.productPrice * this.quantity
    this.total=this.subTotal;
  }

  onCheckboxChange() {
    console.log('Checkbox selection changed. New value:', this.isShipToDifferentAddress);
    // Autres actions à effectuer en fonction de l'état de la sélection du checkbox
  }
  
  onPaymentMethodPaypal(){
    this.paymentForm.value.paymentMethod = 'paypal'
  }
  onPaymentMethodChange() { 
    const selectedValue = this.paymentForm.value.paymentMethod;
    this.showCreditCardLogos = (selectedValue === 'credit-card');
  }
  onPaymentMethodcash() { 
    
    this.paymentForm.value.paymentMethod = 'cash'
  }

  deleteProduct(index: number) {
    // Supprimez le produit du tableau en utilisant son index
    this.produits.splice(index, 1);
  }
 
   
  
  updateTotal() {
    this.subTotal = this.quantity * this.productPrice;
    this.total=this.subTotal;
  }
  decreaseQuantity() {
    if (this.quantity > 1) {
      this.quantity--;
    }
    this.buttonDecreaseClicked = true;
    setTimeout(() => {
      this.buttonDecreaseClicked = false;
    }, 500);
    this.updateTotal();
  }

  increaseQuantity() {
    this.quantity++;
    this.buttonIncreaseClicked = true;
    setTimeout(() => {
      this.buttonIncreaseClicked = false;
    }, 500);
    this.updateTotal();
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
    const headers = new HttpHeaders({'token': token, 'amount': this.total.toString()});
    this.http.post<any>('http://localhost:8081/payment/charge', {}
    , {headers: headers})
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
