import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Key } from 'protractor';
@Component({
  selector: 'app-village-posts',
  templateUrl: './village-posts.component.html',
  styleUrls: ['./village-posts.component.css']
})
export class VillagePostsComponent implements OnInit {

  postpojo:PostPojo= new PostPojo();
  data:PostPojo = new PostPojo();
  aaa:Array<PostPojo>;
  problem:string
  message:any
  name:any
  status:any
  dateline:any
  dept:any
  

  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit() {

    
  }

  
  
  fetch()
  {
  var url = "http://localhost:8081/post";
  this.http.post<Array<PostPojo>>(url,this.postpojo).subscribe(data=>{
  this.aaa=data;
  JSON.stringify(data);
      //alert(temp);
      alert(JSON.stringify(data));
      alert(JSON.stringify(this.aaa[0]));
      const temp = JSON.stringify(this.aaa[0])
      const noerr = true;             
      JSON.parse(temp,(key,value)=>{
      if(key=='complaintId')
      {
      noerr:false;
     alert(value);
      sessionStorage['complaintId']=JSON.stringify(value);
      alert( sessionStorage['complaintId']+"yoyo");
      }
      sessionStorage['message']=JSON.stringify(this.aaa[0].message)
      this.message =  sessionStorage['message']
      sessionStorage[' dateline'] = JSON.stringify(this.aaa[0].dateline)
      this.dateline = sessionStorage['dateline']
      sessionStorage['name1'] = JSON.stringify(this.aaa[0].name)
      this.name = sessionStorage['name1']
      sessionStorage['dept'] = JSON.stringify(this.aaa[0].dept)
      this.dept = sessionStorage['dept']
      sessionStorage['status'] = JSON.stringify(this.aaa[0].status)
      this.status = sessionStorage['status']

      alert(this.message)
  })
  })
}
}
class PostPojo
{
  compaintid:BigInteger
  name:string
  image:Blob
  message:string
  dateline:string
  dept:string
  status:string
}