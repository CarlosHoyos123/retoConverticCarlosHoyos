import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Categories } from 'src/app/interface/categories';
import { productServicio } from 'src/app/servicios/product.service';

@Component({
  selector: 'app-categories-table',
  templateUrl: './categories-table.component.html',
  styleUrls: ['./categories-table.component.css']
})
export class CategoriesTableComponent implements OnInit{

  constructor(
    private _serviceProd: productServicio
  ){ }

  @Output() selected: EventEmitter<Categories> = new EventEmitter; 
  categories: Categories[] = [];

  ngOnInit(){
    this._serviceProd.categoriesList().
      subscribe((response: Categories[])=>{
        this.categories = response;      
      })
  }

  categorieSelected(selection: Categories){
    this.selected.emit(selection);
  }

}
