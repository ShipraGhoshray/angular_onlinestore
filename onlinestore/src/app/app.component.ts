import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
//import {FormControl, FormGroup} from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {OnlinestoreService} from './onlinestore.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'onlinestore';
  //constructor(private http:HttpClient) {}
  constructor(private onlinestoreService: OnlinestoreService) {}

  private baseUrl:string = 'http://localhost:8080';
  private productUrl:string = this.baseUrl + '/product/v1/';

  products: Product[];
  productSearchForm: FormGroup;
  currentName: string;
  currentPrice: number;
  currentType:string;
  currentProducts: Products[];

  ngOnInit() {
	  this.productSearchForm = new FormGroup ({
      name: new FormControl(''),
      type: new FormControl(''),
      price: new FormControl('')
    });

    this.productSearchForm.valueChanges.subscribe(form => {

      this.name = form.name;
      this.type = form.type;
      this.price = form.price;

      console.log(this.name);
      console.log(this.type);
      console.log(this.name);
      console.log(this.price);
    });


    this.products = [ new Product(101, "Bread", 10 ,"Grocceries"),
    	new Product(201, "Milk", 12, "Grocceries"),
    	new Product(301, "Chicken", 14, "Grocceries")
    ];
    
    this.get
  }

	  getCurrentProducts() {
    	this.onlinestoreService.getProducts().subscribe( getResult => {
        console.log(getResult);
        this.currentProducts = getResult;
      });
  }
  
  createProducts() {
    this.onlinestoreService.createProducts(new Product(this.currentName, this.currentType, this.currentPrice)).subscribe(postResult => {
      console.log(postResult);
      this.getCurrentProducts();
    });
  }
}	
	
export class Product {
  productId: number;
  name: string;
  price: number;
  type:string;

  constructor(productId: number, name: string, price: number, type:string) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.type = type;
  }
}

