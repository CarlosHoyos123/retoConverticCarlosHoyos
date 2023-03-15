import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ProductEntity } from 'src/app/interface/productEntity';
import { SearchModel } from 'src/app/interface/searchModel';
import { AuthServicio } from 'src/app/servicios/auth.service';
import { productServicio } from 'src/app/servicios/product.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: 'nav-bar.component.html',
})
export class NavBarComponent implements OnInit{

  constructor(
    private _auth: AuthServicio,
    private _productService: productServicio,
    private _router: Router) {}

  ImagenLogo =  "../../../../assets/images/Convertic.JPG";
  aBuscar= "";
  profileMsg: string = "Mi perfil";
  public searchInfo: SearchModel = {
    products: [], active: false 
  };
  @Output() info: EventEmitter<SearchModel> = new EventEmitter();

  ngOnInit(): void {
    this._auth.session;
  }

  oneKeyup(){
    if (this.aBuscar != '') {
      this._productService.searchresults(this.aBuscar.toLocaleLowerCase()).
        subscribe((results: ProductEntity[])=>{
          this.searchInfo.products = results;
          this.searchInfo.active = true;
          this.info.emit(this.searchInfo);
        }).add()
    }else{
      this.searchInfo.products = [];
      this.searchInfo.active = false;
      this.info.emit(this.searchInfo);
    }
  }
  
  toCart(){
    this._router.navigate(['Tienda/carrito']); 
  }

  closeSession(){
    this._auth.cerrarSesion();
    this._router.navigate([''])
  }
}
