import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currency_rate:number=1
  constructor() { }
  currency_symbole:string='';
  ngOnInit(): void {
    this.loadnewprice();
    
  }
  reloadpage()
  {


    location.reload();
  }

  

  async loadnewprice(){
    
   
    
    await fetch('https://api.ipdata.co?api-key=4c2784853ff1cbf16f867a26b9582961f5767a273ab025d38b9bb11d&fields=currency')
   .then( res => res.json())
   .then(response => {
     var  currency_symbol= response.currency.code;
      // console.log("Country: ", currency_symbol);
       this.currency_symbole=currency_symbol
       localStorage.setItem('symbol',this.currency_symbole.toString());
       
       
    });
    
    const selectElement : any  = document.getElementById('currency');
    selectElement.value =  this.currency_symbole;
const currencies = ['usd', 'euro', 'tnd'];

    if (currencies.includes(this.currency_symbole.toLowerCase())) {
      selectElement.value =  this.currency_symbole;
  } else {
    const newOption = document.createElement('option');
    newOption.value = this.currency_symbole;
    newOption.textContent = this.currency_symbole;
    selectElement.appendChild(newOption);
    selectElement.value =  this.currency_symbole;
    
  }
  await fetch('https://openexchangerates.org/api/latest.json?app_id=5d0f971872674d5395ef72802b13d7f9')
  .then( res => res.json())
  .then(response => {
      
      Object.keys(response.rates).forEach(key => {
        if(this.currency_symbole==key)
        { 
          this.currency_rate=response.rates[key];
    
  }
  
    
   let prix=document.getElementById('price');
   if (prix){
   prix.innerHTML=Math.floor(40*this.currency_rate).toString()+' '+this.currency_symbole;}
  });
   })
}


 updateCurrencySymbol() {
  const selectElement:any = document.getElementById('currency');
  const selectedValue = selectElement.value;
  

}
}
