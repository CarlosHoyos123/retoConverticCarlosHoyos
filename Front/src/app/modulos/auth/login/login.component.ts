import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/interface/login';
import { RespuestaApi } from 'src/app/interface/respuestaapi';
import { AuthServicio } from 'src/app/servicios/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {

  @ViewChild('closebutton')
  closebutton!: { nativeElement: { click: () => void; }; };
  public login: Login = { correo: '', clave: '' }
  nuevoUsuarioMensaje: string = "Formulario de registro";
  RegisterMsg: string = "Registrarse";
  logInMsg: string = "Ingresar";

  constructor(private _servicio: AuthServicio, private _router: Router) {

  }

  onSubmit() {
    this._servicio.Login(this.login)
      .subscribe((response: RespuestaApi) => {
        if (response.state) {
          this._servicio.session = response;
          this._router.navigate(['Tienda/home/man']);
        }else{
          alert("Datos no son correctos, sirvase verificarlos");
        }
      }).add(() => {

      });
  }

  OnSignIn(){
    this._router.navigate(['Auth/registro']);
  }

  closeRegistry(event: boolean){
    if(event){
      alert("Se ha creado el usuario");
      this.closebutton.nativeElement.click();
    }else{
      alert("Error creando el usuario");
      this.closebutton.nativeElement.click();
    }

  }
}
