import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  constructor(private http: HttpClient) { }

 addreview(name:any,firstName:any,description:any,imagePath:any,note:any){
  
  const body = {
    name: name+" "+firstName,
    description: description,
    img: imagePath,
    note: note
  };
  console.log(body);
  const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  
  this.http.post('http://localhost:8081/feedback/addreview', body, { headers: headers })
    .subscribe(
      (response) => {
        // Handle successful response here
        console.log('Review added successfully', response);
      },
      (error) => {
        // Handle error here
        console.error('Error adding review', error);
      }
    );
 }
}
