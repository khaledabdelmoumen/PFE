import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObservedValuesFromArray } from 'rxjs';
import { ProductserviceService } from '../service/productservice.service';

@Component({
  selector: 'app-tap-water-filter',
  templateUrl: './tap-water-filter.component.html',
  styleUrls: ['./tap-water-filter.component.css'],
  
})
export class TapWaterFilterComponent implements OnInit {
  name="khaled"
  firstname="abdelmoumen"
  reviewtxt="aaaaaaaa"
  email="aaaaaaa"
imgpath:any;


  ProductRating:any = 0;
  currentStep = 1;
  reviewData = {
    stars: null,
    description: '',
    image: '',
    name: '',
    email: ''
  };
  itemsArray:any = [] ; 
  maxStars = 5;
  currentRating = 0;
  starsArray = Array;
  starRatings: { stars: number, count: number }[] = [];
  showDropdownFlag:any = false;
  numberofreviews: number = 0;
  reviews: any[] = [];
  stars: number[] = [];
  quantity: number = 1;
  productName: string = 'The Dracoss Water Purifier Filter';
  productPrice: number = 35;
  productDescription: string =
    'The Dracoss Water Tap Purifier is a revolutionary device designed to transform your regular tap water into clean, safe, and great-tasting water. Powered by an advanced filtration technology, it effectively reduces common contaminants like chlorine, heavy metals, bacteria, and sediments, while retaining beneficial minerals.';
  averageRating: number = 0;
  currency_rate: number = 1;
  currency_symbole: string = '';
  buttonIncreaseClicked = false;
  buttonDecreaseClicked = false;
  showTabContentimpact: boolean = false;
  showTabContentFeatures: boolean = false;
  showTabContentDetails: boolean = false;
  showTabContentTechnicalOverview: boolean = false;
  showTabContentShipping: boolean = false;
  activeTab: string = '';
  rating: number = 3.5;
  selectedColor!: string;
  animationState: string = 'out';
  selectedImageIndex: number = 0;
  selectedImage: string = '../../assets/images/product/1.PNG';
  imageList: string[] = [
    '../../assets/images/product/2.png',
    '../../assets/images/product/3.PNG',
    '../../assets/images/product/4.JPG',
    '../../assets/images/product/5.JPG',
    '../../assets/images/product/6.png',
    // Ajoutez plus de chemins d'accès d'images si nécessaire
  ];

  isImageZoomed: boolean = false;
  zoomStartPosition: { x: number; y: number } = { x: 0, y: 0 };
  dragStartPosition: { x: number; y: number } = { x: 0, y: 0 };
  shouldDelayTransition: boolean = false;
  
  constructor(private router: Router, private http: HttpClient,private Productservice:ProductserviceService) {}
  uploadImage(event: Event) {
    const inputElement = event.target as HTMLInputElement;

    if (inputElement && inputElement.files && inputElement.files[0]) {
   
      const file = inputElement.files[0];
      const formData = new FormData();
      const encodedFileName = file.name.replace(/ /g, '_');
      formData.append('file', file, encodedFileName);
  
    this.http.post<any>('http://localhost:8081/feedback/upload', formData).subscribe(response => {
       // Assuming the response contains the path to the uploaded image
      const imagePath:any = response;
  this.imgpath=response.filePath;
  console.log(response.filePath);    
      // Now you can send the review data including the image path to your backend
    });
  }
  }
  setrating(x:any){
    this.ProductRating=x;
  

  }

 
  nextStep() {
    if (this.currentStep < 4) {
      if (this.shouldDelayTransition) {
        setTimeout(() => {
          this.currentStep++;
        }, 1000); // Adjust the delay time (in milliseconds) as needed
      } else {
        this.currentStep++;
      }
    }
  }
  
  // Add a click event handler for the star element
  
  divStyle = {
    display: 'none'
  };
  setRating(rating: number) {
    this.currentRating = rating
   this.nextStep();

  }
  ngOnInit(): void {
    this.http
      .get<any[]>('http://localhost:8081/feedback/getallfeedbacks')
      .subscribe((res) => {
        this.reviews = res;

        this.numberofreviews = this.reviews.length;
      });
  
    this.getAverageRating();


    const item = localStorage.getItem('itemName');

    if (item !== null) {
      const item: string = localStorage.getItem('price')!;
      let prix=document.getElementById('price');
      if (prix){
      prix.innerHTML=Math.floor(40*this.currency_rate).toString()+' '+this.currency_symbole;}

    } else {
      console.log('Item not found');
    }
  }




  previousStep() {
    if (this.currentStep > 1) {
      this.currentStep--;
    }
  }

  submitReview() {
  this.Productservice.addreview(this.name,this.firstname,this.reviewtxt,this.imgpath,this.ProductRating);
  alert("review added succesfully")
  window.location.reload();
  }



  getPercentage(test:any): number {
    return (this.starRatings[test].count / this.reviews.length) * 100;
  }
  showDropdown() {
    this.divStyle['display'] = this.divStyle['display'] === 'block' ? 'none' : 'block'
    this.showDropdownFlag = !this.showDropdownFlag;
    this.calculateStarRatings();

   
  }
  calculateStarRatings() {
     this.starRatings = [];


    const ratingCounts:any = {};
    for (let i = 1; i <= 5; i++) {
      ratingCounts[i] = 0;
    }
  
    this.reviews.forEach(review => {
      ratingCounts[review.note]++;
    });
  
    for (let i = 5; i >= 1; i--) {
      this.starRatings.push({ stars: i, count: ratingCounts[i] });
    }
  }
  getAverageRating() {
    // Fetch average rating from your backend
    this.http
      .get<number>('http://localhost:8081/feedback/average')
      .subscribe((res) => {
        this.averageRating = res;
        
      
        this.stars = Array(Math.floor(this.averageRating)).fill(1);
        if (this.averageRating % 1 !== 0) {
          this.stars.push(0.5);
        }
      });
  }
  /*async loadnewprice(){
 await fetch('https://api.ipdata.co?api-key=4c2784853ff1cbf16f867a26b9582961f5767a273ab025d38b9bb11d&fields=currency')
.then( res => res.json())
.then(response => {
  var  currency_symbol= response.currency.code;
   // console.log("Country: ", currency_symbol);
    this.currency_symbole=currency_symbol
   
    
 });

 await fetch('https://openexchangerates.org/api/latest.json?app_id=5d0f971872674d5395ef72802b13d7f9')
.then( res => res.json())
.then(response => {
    
    Object.keys(response.rates).forEach(key => {
      if(this.currency_symbole==key)
      { 
        this.currency_rate=response.rates[key];
  //console.log(key, response.rates[key],35*this.currency_rate);
}

  
 let prix=document.getElementById('price');
 if (prix){
 prix.innerHTML=(35*this.currency_rate).toString()+' '+this.currency_symbole;}
});
 })



 
}*/

  selectColor(color: string) {
    this.selectedColor = color;
  }

  startDrag(event: MouseEvent) {
    if (this.isImageZoomed) {
      this.zoomStartPosition = { x: event.clientX, y: event.clientY };
      this.dragStartPosition = { x: event.clientX, y: event.clientY };
    }
  }

  doDrag(event: MouseEvent) {
    if (this.isImageZoomed) {
      const deltaX = event.clientX - this.dragStartPosition.x;
      const deltaY = event.clientY - this.dragStartPosition.y;

      // Effectuer des calculs pour ajuster le zoom en fonction du mouvement
      // Utilisez deltaX et deltaY pour modifier la taille ou la position de l'image selon vos besoins
      // Par exemple : this.zoomedSize = this.originalSize + (deltaX * 0.1);

      // Mettre à jour la position de départ pour le prochain mouvement
      this.dragStartPosition = { x: event.clientX, y: event.clientY };
    }
  }

  endDrag() {
    if (this.isImageZoomed) {
      // Effectuez les actions nécessaires à la fin du glissement, si nécessaire
    }
  }

  updateSelectedImage(imageIndex: number) {
    const tempImage = this.imageList[imageIndex];
    this.imageList[imageIndex] = this.selectedImage;
    this.selectedImage = tempImage;
    this.selectedImageIndex = imageIndex;

    this.isImageZoomed = true; // Réinitialiser l'état du zoom de l'image lors du changement
  }
  toggleImageZoom() {
    this.isImageZoomed = !this.isImageZoomed;
  }
  decreaseQuantity() {
    if (this.quantity > 1) {
      this.quantity--;
    }
    this.buttonDecreaseClicked = true;
    setTimeout(() => {
      this.buttonDecreaseClicked = false;
    }, 500);
  }

  increaseQuantity() {
    this.quantity++;
    this.buttonIncreaseClicked = true;
    setTimeout(() => {
      this.buttonIncreaseClicked = false;
    }, 500);
  }

  addToCart() {
    // Logique pour ajouter le produit au panier
    console.log('Product added to cart:', this.quantity);
    this.router.navigate(['/checkout'], {
      queryParams: {
        productName: this.productName,
        productPrice: this.productPrice,
        quantity: this.quantity,
      },
    });
  }

  toggleTabContentFeatures() {
    this.showTabContentFeatures = !this.showTabContentFeatures;
    this.showTabContentDetails = false;
    this.showTabContentTechnicalOverview = false;
    this.showTabContentShipping = false;
    this.showTabContentimpact = false;
  }

  toggleTabContentShipping() {
    this.showTabContentShipping = !this.showTabContentShipping;
    this.showTabContentDetails = false;
    this.showTabContentTechnicalOverview = false;
    this.showTabContentFeatures = false;
    this.showTabContentimpact = false;
  }

  toggleTabContentimpact() {
    this.showTabContentimpact = !this.showTabContentimpact;
    this.showTabContentDetails = false;
    this.showTabContentTechnicalOverview = false;
    this.showTabContentFeatures = false;
  }

  toggleTabContentDetails() {
    this.showTabContentDetails = !this.showTabContentDetails;
    this.showTabContentTechnicalOverview = false;
    this.showTabContentFeatures = false;
    this.showTabContentShipping = false;
    this.showTabContentimpact = false;
  }

  toggleTabContentTechnicalOverview() {
    this.showTabContentTechnicalOverview =
      !this.showTabContentTechnicalOverview;
    this.showTabContentDetails = false;
    this.showTabContentFeatures = false;
    this.showTabContentShipping = false;
    this.showTabContentimpact = false;
  }
}
