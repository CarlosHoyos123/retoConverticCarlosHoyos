import { Component, OnInit } from '@angular/core';
import { SearchModel } from 'src/app/interface/searchModel';
import { AuthServicio } from 'src/app/servicios/auth.service';

@Component({
  selector: 'app-layout-home',
  templateUrl: './layout-home.component.html',
})
export class LayoutHomeComponent implements OnInit{

  constructor(
    private _Auth: AuthServicio
  ) { }

  infoSearch: SearchModel = {
    products: [], active: false 
  };

  ngOnInit(){
    this._Auth.session;
  }

  setSearchBarResults(event: SearchModel){
    this.infoSearch = event;
  }
}
