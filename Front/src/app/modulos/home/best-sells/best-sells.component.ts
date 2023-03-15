import { Component, Input } from '@angular/core';
import { ProductEntity } from 'src/app/interface/productEntity';

@Component({
  selector: 'app-best-sells',
  templateUrl: './best-sells.component.html',
})
export class BestSellsComponent {

  rutaImagen = "../../../../assets/images/No_disponible.jpg";
  
  @Input() productP?: ProductEntity;
}
