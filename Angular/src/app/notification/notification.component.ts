import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  constructor(private http:HttpClient,private router:Router) { }

 // postpojo:Reply= new Reply();
  reply:Reply = new Reply();
  aaa:any
//  problem:string
  ngOnInit() {
    this.reply.complaintId = sessionStorage['complaintId']
   // this.fetchNotification()
  }

fetchNotification()
{
  alert("hii...")
  alert("hellos" +this.reply.complaintId)

  var url = "http://localhost:8081/notification"
  alert("hellos" +this.reply.complaintId)
  this.http.post<Reply>(url,this.reply).subscribe(data=>{
    alert(JSON.stringify(data))
    alert("hellos" +this.reply.complaintId)
 // this.aaa=data
})
}

}

class Reply
{
   content:String;
	 forwardto:String ;
	  complaintId:BigInteger;
	 dateOfReply:Date;
}
