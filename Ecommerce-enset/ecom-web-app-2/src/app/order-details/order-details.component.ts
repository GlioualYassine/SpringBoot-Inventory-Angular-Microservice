import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent {
  ordersDetails : any ;
  orderId !: number; // pour ne pas l'initialiser
  constructor(private http:HttpClient , private router:Router , private route:ActivatedRoute) {
    this.orderId = route.snapshot.params["orderId"]

  }
  ngOnInit() {
    this.http.get("http://localhost:9999/order-service/fullOrder/"+this.orderId).subscribe({
      next : (data)=>{
        this.ordersDetails = data;
      },
      error : (err)=>{
      }
    })
  }

}
