import { Component, OnInit } from '@angular/core';
import "src/assets/js/smtp.js";
import { FormGroup, FormControl } from "@angular/forms";

declare let Email: any;

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  ContactForm = new FormGroup({
    name: new FormControl(""),
    email: new FormControl(""),
    phone: new FormControl(""),
    subject: new FormControl(""),
    message: new FormControl(""),
      
      
    
  });

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {

    Email.send({
      Host : "smtp.elasticemail.com",
      Username : "Khaled98.dracoss@gmail.com",
      Password : "AC96A39C2FFA3590370907D7DB20D78CADC9",
      To : "contact@dracoss.tech",
      From : "Khaled98.dracoss@gmail.com",
      Subject :this.ContactForm.value.subject,
      Body : "<i>This is sent as An Email from "+this.ContactForm.value.email+".</i> <br/> <b>Name: "+this.ContactForm.value.name+"<br><b>Phone</b> "+this.ContactForm.value.phone+"<br> <b>The reclation</b> is "+this.ContactForm.value.message
    
      
    
      
    
    
     
      }).then ( alert("aa"));
      window.location.href='/confirmation';

}}