import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent {
  orders : any ;
  customerId !: number; // pour ne pas l'initialiser
  constructor(private http:HttpClient , private router:Router , private route:ActivatedRoute) {
    this.customerId = route.snapshot.params["customerId"]

  }
  getOrders(c:any):void{
    this.router.navigateByUrl("/orders/"+c.id);
  }
  ngOnInit() {
    this.http.get("http://localhost:9999/order-service/orders/search/bycustomerId?projection=fullOrder&customerId="+this.customerId).subscribe({
      next : (data)=>{
        this.orders = data;
      },
      error : (err)=>{
      }
    })
  }

  getOrderDetails(p: any) {
   this.router.navigateByUrl("/ordersDetails/"+p.id)
  }
}
