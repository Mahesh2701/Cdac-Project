import { Component, OnInit } from '@angular/core';
import  {HttpClient}from '@angular/common/http';
import {Router}from '@angular/router'
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-problemform',
  templateUrl: './problemform.component.html',
  styleUrls: ['./problemform.component.css'],
  providers: [DatePipe]
})



export class ProblemformComponent implements OnInit {
  postObj:post = new post(); 

  myDate: string;
  problem:string;
   
  constructor(private datePipe: DatePipe,private http:HttpClient,private router:Router) {
    this.myDate = this.datePipe.transform(this.myDate, 'yyyy-MM-dd');
   }

  post()
  {
    this.problem=localStorage['linkvalue']
    alert(this.problem)
    var url = "http://localhost:8081/problemform"
      this.http.post(url,this.postObj).subscribe(response=> {}) 
      
      alert(JSON.stringify(this.postObj))
      this.router.navigate(['/post'])
  }
  

  ngOnInit() {
   
  }

}

class post
{
name:string
image:Blob
message:string
dateline:string
dept:string
}

