import { Component, OnInit, LOCALE_ID, Inject, Output, EventEmitter, ViewChild } from '@angular/core';
import { AuthServicio } from 'src/app/servicios/auth.service';
import { carServicio } from 'src/app/servicios/car.service';
import { ItemToCar } from 'src/app/interface/itemToCar';
import { CarResponse } from 'src/app/interface/carResponse';
import { SellConfirmation } from 'src/app/interface/sellConfirmation';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart-description',
  templateUrl: './cart-description.component.html',
})
export class CartDescriptionComponent implements OnInit{

  @ViewChild('closebutton')
  closebutton!: { nativeElement: { click: () => void; }; };

  items: CarResponse[]= [];
  client: number=0;
  subTotal:number = 0;
  iva:number = 0.19;
  totalItemsToBuy: number = 0;
  invoiceDefaultState:number = 1;
  newSellMsg: string = "Formulario de confirmación de compra";
  confirmMsg: string = "Confirmar compra";
  carItems: ItemToCar= {
      cliente:0,
      desde: '',
      producto: 0,
      talla: 0,
      color: 0,
      cantidad: 0
  };
  confirmInformation: SellConfirmation = {
    invoice: {
      fecha: '',
      cliente: 0,
      total: 0,
      estado: 0,
      dir_envio: 0,
      dir_facturacion: 0
    },
    invoiceDetail: [],
    car:[]
  }

  constructor(
    private _router: Router,
    private _carService: carServicio,
    private _Auth: AuthServicio,
    @Inject(LOCALE_ID) public locale: string
  ) { }

  ngOnInit(): void {
    let session = this._Auth.session;
    this.client = session.client.cliente;
    this._carService.checkClientCar(session.client.cliente). 
    subscribe((response: CarResponse[])=>{
      this.items = response;
      this.calculations();
    });
  }

  goToHome(){
    this._router.navigate(['Tienda/home/man']);
  }

  deleteItemInCar(event: CarResponse){
    this._carService.deleteItem(event). 
    subscribe((response: CarResponse)=>{
      alert("Se ha eliminado el item: "+response.producto.producto);
      let index = this.items.findIndex(pRow => pRow.idCar == event.idCar);
      this.items.splice(index, 1);
      this.calculations();
    })
  }

  calculations(){
    this.totalItemsToBuy = 0;
    this.subTotal = 0;
    this.items.forEach(item => {
      this.totalItemsToBuy += item.cantidad;
      this.subTotal += item.producto.precio*item.cantidad;
    });
  }

  closeDialog(event: boolean){
    this.closebutton.nativeElement.click();
    this._router.navigate(['Tienda/home/man']);
    alert("La compra se ha confirmado, producto agendado para entrega.")
  }
}
