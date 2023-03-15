import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { HomeGridProduct } from 'src/app/interface/homeGridPriduct';
import { productServicio } from 'src/app/servicios/product.service';


@Component({
  selector: 'app-grid-list',
  templateUrl: './grid-list.component.html'
})
export class GridListComponent implements OnInit{

  constructor(
    private _productService: productServicio,
    private _activatedRoute: ActivatedRoute
    ) {}

  sex: string = "man";
  ImagenLogo =  "../../../../assets/images/Convertic.JPG";
  welcomeImagenPath = "";
 
  productsMainGridList: HomeGridProduct[] = [];
  
  ngOnInit(){
    this._activatedRoute.paramMap. 
      subscribe((params: ParamMap) => {
        this.sex = params.get('gender') || "man";
        this.gridSexProductList(this.sex);
      })
  }

  gridSexProductList(sex: string ){
    this._productService.sexProductList(sex). 
      subscribe((response: HomeGridProduct[]) =>{
        this.productsMainGridList = response;
      })
  }

}
