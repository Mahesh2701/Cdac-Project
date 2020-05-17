import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  constructor(private http:HttpClient,private router:Router) { }
  reply: Reply = new Reply();
  fetchReply:Reply= new Reply();
  data:Reply = new Reply();
  b:BigInteger
  //postID:12;
  aaa:Array<Reply>;
 

  ngOnInit() {
   this.reply.complaintId = sessionStorage['complaintId']
   this.reply.forwardfrom= sessionStorage['name']
   alert( this.reply.forwardfrom)
  }

  inComment()
  {
    //alert(this.reply.comment)
    var url = "http://localhost:8081/comment"
    this.http.post<Reply>(url,this.reply).subscribe(data=>{}) 
    alert(JSON.stringify(this.reply));
  }

  // fetchComment()
  // {
  //   var url = "http://localhost:8081/fetchcomment";
  //   this.http.post<Reply>(url,this.fetchReply).subscribe(data=>{
  //     alert(data);
  //   alert(JSON.stringify(this.fetchReply));
  //   //this.aaa=data;
  //   })

  // }

  fetchComment()  {
    alert("hey!!!!!!!!!!!!!!!!");
  var url = "http://localhost:8081/fetchcomment";
  this.http.post<Array<Reply>>(url,this.reply).subscribe(data=>{
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
  })
  })
}

}

class Reply
{
  content:String;
	forwardto:String ;
	complaintId:BigInteger;
  dateOfReply:Date;
  forwardfrom:string
}