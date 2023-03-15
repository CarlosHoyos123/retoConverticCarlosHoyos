import { formatDate } from '@angular/common';
import { Component, EventEmitter, Inject, Input, LOCALE_ID, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AdressToInvoice } from 'src/app/interface/adressToInvoice';
import { AdressToSend } from 'src/app/interface/adressToSend';
import { CarResponse } from 'src/app/interface/carResponse';
import { SellConfirmation } from 'src/app/interface/sellConfirmation';
import { AuthServicio } from 'src/app/servicios/auth.service';
import { carServicio } from 'src/app/servicios/car.service';

@Component({
  selector: 'app-send-description',
  templateUrl: './send-description.component.html',
})
export class SendDescriptionComponent implements OnInit{

  @Input() carItems: CarResponse[] = [];
  @Output() confirmed: EventEmitter<boolean> = new EventEmitter;
  cliente: number=0;
  clientName: string = "";
  invoiceDefaultState: number = 1;
  items: CarResponse[]= [];
  sendAdress: AdressToSend={
    id: 0,
    direccion: "",
    zipCode: "",
    cliente: 0,
    pais: 0
  };
  invoiceAdress: AdressToInvoice={
    id: 0,
    direccion: "",
    zipCode: "",
    cliente:0,
    pais: 0
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
    car: []
  }

  constructor(
    private _carService: carServicio,
    private _Auth: AuthServicio,
    private _router: Router,
    @Inject(LOCALE_ID) public locale: string
  ){  }

  ngOnInit(): void {
    let session = this._Auth.session;
    this.sendAdress = session.sendAdress;
    this.invoiceAdress = session.invoiceAdress;
    this.clientName = session.client.primerNombre;
    this.cliente = session.client.cliente

  }
  terminateSell(){
    let date = formatDate(new Date(), 'yyyy-MM-dd', this.locale);;
    this.confirmInformation.invoiceDetail = [];
    this.confirmInformation.invoice.cliente = this.cliente;
    this.confirmInformation.invoice.dir_envio = this.sendAdress.id;
    this.confirmInformation.invoice.dir_facturacion = this.invoiceAdress.id;
    this.confirmInformation.invoice.fecha = date;
    this.confirmInformation.invoice.estado = this.invoiceDefaultState;
    this.confirmInformation.car = this.carItems;
    console.log(this.confirmInformation);
    this._carService.sellConfirm(this.confirmInformation).
      subscribe((response:SellConfirmation)=>{
        this.confirmed.emit(true);
      })
  }
  
}
