import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {

  constructor(private http:HttpClient,private router:Router) { }
  user:User = new User();
  data:User = new User();
  ngOnInit() {
    this.fetchprofile();
  }

  fetchprofile()
  {

    var url = "http://localhost:8081/fetchprofile"
     var aaa = sessionStorage['name']
      this.http.post<User>(url,aaa).subscribe(tdata=> {
      this.data=tdata;
      alert(tdata.fullname)
      //alert(JSON.stringify(this.Data))
      //console.log(data);
    }) 
   
    //this.router.navigate(['/villagepost'])




  }

  updateuser()
  {

    console.log("yoyo")
    var url = "http://localhost:8081/updateuser"
    //// var aaa = sessionStorage['name']
     console.log("hiii")
    this.http.post<User>(url,this.data).subscribe(data=> {

     // alert(this.data)
      this.router.navigate(['/villagepost'])
  
  })
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