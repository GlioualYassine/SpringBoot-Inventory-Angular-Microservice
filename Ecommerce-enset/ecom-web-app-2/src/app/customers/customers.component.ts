import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router, RouterModule} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent {
  customers : any ;
  constructor(private http:HttpClient , private router:Router) {

  }
  getOrders(c:any):void{
    this.router.navigateByUrl("/orders/"+c.id);
}
  ngOnInit() {
    this.http.get("http://localhost:9999/customer-service/customers?projection=fullCustomer").subscribe({
      next : (data)=>{
        this.customers = data;
      },
      error : (err)=>{
      }
    })
  }
}
