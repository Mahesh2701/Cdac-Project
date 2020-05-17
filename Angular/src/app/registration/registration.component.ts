import { Component, OnInit } from '@angular/core';
import  {HttpClient}from '@angular/common/http';
import {Router}from '@angular/router'

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user: User = new User();
  // obj:Object = new Object();

  constructor(private http:HttpClient,private router:Router) {
  }

  register()
  {
    var url = "http://localhost:8081/registration"
    this.http.post(url,this.user).subscribe(response=> {}) 

    alert(JSON.stringify(this.user))
    this.router.navigate(['/login'])

   }

  ngOnInit() {
    
  }

}

class User
{
fullname:string
address:string
pincode:string
dob:string
username:string
password:string
villageName:string
}
  