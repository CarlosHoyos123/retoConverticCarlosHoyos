import { Component } from '@angular/core';
import { Country } from 'src/app/interface/country';
import { FormConfig } from 'src/app/interface/formsConfig';
import { IdType } from 'src/app/interface/idType';
import { AuthServicio } from 'src/app/servicios/auth.service';
import { PhoneType } from 'src/app/interface/phoneType';
import { ClientUpdate } from 'src/app/interface/clientUpdate';

@Component({
  selector: 'app-profile-description',
  templateUrl: './profile-description.component.html',
})
export class ProfileDescriptionComponent {
  
  constructor(
    private _Auth: AuthServicio
  ){ }

passwordConfirm:  string = '';
selectCountryInfo: Country[] = [];
selectPhoneInfo: PhoneType[] = [];
selectDocumentInfo: IdType[] = [];
infoToUpdate: ClientUpdate={
  client: {
    cliente:            0,
    email:              "",
    contrasenia:        "",
    primerNombre:       "",
    segundoNombre:      "",
    primerApellido:     "",
    segundoApellido:    "",
    tipoTelefono:       {id: 0, tipoTelefono: ""},
    telefono:           "",
    pais:               {id: 0, nombrePais: ""},
    numeroDocumento:    "",
    tipoDocumento:      {id: 0, tipoDocumento: ""}
  },
  adresstosend: {
    id:           0,
    direccion:    "",
    zipCode:      "",
    cliente:      0,
    pais:         0
  },
  adressToInvoice: {
    id:           0,
    direccion:    "",
    zipCode:      "",
    cliente:      0,
    pais:         0
  } 
}

  ngOnInit(): void {
    let session = this._Auth.session;
    this.infoToUpdate.client = session.client;
    this.infoToUpdate.adressToInvoice = session.invoiceAdress;
    this.infoToUpdate.adresstosend = session.sendAdress;
    
    if (this._Auth.FormsData === null) {
      this._Auth.formsInfo(). 
        subscribe((response: FormConfig)=>{
          console.log(response);
          this._Auth.FormsData = response;
       }).add()
    }else{
      let formsInfo = this._Auth.FormsData;
      this.selectCountryInfo = formsInfo.countries;
      this.selectDocumentInfo = formsInfo.documents;
      this.selectPhoneInfo = formsInfo.phones;
    }
  }

  onSubmit(){
    if(this.infoToUpdate.client.contrasenia == this.passwordConfirm){
    this._Auth.updateUser(this.infoToUpdate).
      subscribe((response: ClientUpdate)=>{
        let currentSession = this._Auth.session;
        currentSession.client = response.client;
        currentSession.invoiceAdress = response.adressToInvoice;
        currentSession.sendAdress = response.adresstosend;
        this._Auth.session = currentSession;
      })
    }else{
      alert("las contraseñas deben ser iguales");
    }
  }
        
}
