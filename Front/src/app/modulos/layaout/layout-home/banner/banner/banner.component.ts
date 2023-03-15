import { Component } from '@angular/core';
import { Categories } from 'src/app/interface/categories';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent {

  header: string = "Seleccione categoria."
 
  findProductsPerCategorie(event: Categories){
    console.log(event);
  }
  
}
