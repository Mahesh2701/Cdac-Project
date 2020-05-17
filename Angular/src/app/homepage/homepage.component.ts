import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor() {
    
   }
   name:string
  ngOnInit() {

    this.name=sessionStorage['name'];
  }

}
