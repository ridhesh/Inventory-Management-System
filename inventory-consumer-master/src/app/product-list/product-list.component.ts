import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Route, Router } from '@angular/router';

import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Observable<Product[]> | any;

  constructor(private productService: ProductService, 
              private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.products = this.productService.getProductsList();
  }

  productDetails(id: number){
    this.router.navigate(['details', id]);
  }

  editProduct(id: number) {
    this.router.navigate(['update',id])  // navigate to component from a method
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
}
