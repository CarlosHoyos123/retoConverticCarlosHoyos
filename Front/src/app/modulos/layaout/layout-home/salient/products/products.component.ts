import { Component, Input, OnInit } from '@angular/core';
import { ProductEntity } from 'src/app/interface/productEntity';
import { SearchModel } from 'src/app/interface/searchModel';
import { productServicio } from 'src/app/servicios/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})

export class ProductsComponent implements OnInit{

  bestSellProducts: ProductEntity[] = [];
  @Input() SearchResults : SearchModel = {
    products: [], active: false 
  };

  constructor(
    private _productService: productServicio
  ){}

  ngOnInit(): void {
    this.loadMostSelling();
  }

  loadMostSelling(){
    this._productService.mostSellingList()
      .subscribe((seleccion: ProductEntity[]) =>
        {
          this.bestSellProducts = seleccion;
        })
      .add()
  }
}
