import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CarResponse } from 'src/app/interface/carResponse';

@Component({
  selector: 'app-list-car-items',
  templateUrl: './list-car-items.component.html',
})
export class ListCarItemsComponent {

@Input() itemsToList: CarResponse[]= [];
@Output() deleteItem: EventEmitter<CarResponse> = new EventEmitter();

delete(item: CarResponse){
  this.deleteItem.emit(item);
}

}
