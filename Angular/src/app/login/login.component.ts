import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

user:User = new User();
data:User = new User();
  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit() {
  }

  
  login()
  {
  var url = "http://localhost:8081/login";
  this.http.post<User>(url,this.user).subscribe(data=>{
  alert(JSON.stringify(data));
  
  if(data.statusCode==333)
  {
    sessionStorage['name']=data.loggedInCustomer.username;
    alert(sessionStorage['name'])
    this.router.navigate(['/villagepost'])
  }
})


  }

}

class User
{
  username : string;
  password : string ;
  loggedInCustomer: any;
  statusCode: number;

}
