import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ClientEntity } from 'src/app/interface/clientEntity';
import { Country } from 'src/app/interface/country';
import { FormConfig } from 'src/app/interface/formsConfig';
import { IdType } from 'src/app/interface/idType';
import { PhoneType } from 'src/app/interface/phoneType';
import { UserCreationResponse } from 'src/app/interface/userCreationResponse';
import { AuthServicio } from 'src/app/servicios/auth.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html'
})
export class RegistroComponent implements OnInit {

  @Output() confirmed: EventEmitter<boolean> = new EventEmitter;
  selectCountryInfo: Country[] = [];
  selectPhoneInfo: PhoneType[] = [];
  selectDocumentInfo: IdType[] = [];
  passwordConfirm:  string= '';

  newUser: ClientEntity = {
    cliente:  0,
    email:  "",
    contrasenia:  "",
    primerNombre: "",
    segundoNombre:  "",
    primerApellido:  "",
    segundoApellido: "",
    tipoTelefono: {id: 0, tipoTelefono: ""},
    telefono: "",
    pais: {id: 0, nombrePais: ""},
    numeroDocumento: "",
    tipoDocumento: {id: 0, tipoDocumento: ""}
  }

    constructor(
      private _AuthService: AuthServicio)
    { }

  ngOnInit(){
      this._AuthService.formsInfo(). 
        subscribe((response: FormConfig)=>{
          this.selectCountryInfo = response.countries;
          this.selectDocumentInfo = response.documents;
          this.selectPhoneInfo = response.phones;
        }).add()
  }

  onSubmit(){    
    if(this.newUser.email.indexOf('@'[0]) != -1 && this.newUser.email.includes(".com")){
      if(this.newUser.contrasenia == this.passwordConfirm && this.newUser.contrasenia.length >= 5){
        this._AuthService.createUser(this.newUser). 
          subscribe((response: UserCreationResponse)=>{
            console.log(response);
          if(response.description == "User created"){
            this.confirmed.emit(true);
          }else{
            this.confirmed.emit(false);
          }
        }).add()  
      } else {alert("Las contraseñas deben ser iguales y tener una longitud mínima de 5.");}
    }else{ alert("Correo Invalido"); }
  }
}
