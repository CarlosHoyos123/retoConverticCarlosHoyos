import { Injectable } from '@angular/core';
import { HttpClient  } from '@angular/common/http';
import { Observable, of  } from 'rxjs';

/** Interfaces */
import { Login } from '../interface/login';
import { RespuestaApi } from '../interface/respuestaapi';
import { FormConfig } from '../interface/formsConfig';
import { ClientEntity } from '../interface/clientEntity';
import { Router } from '@angular/router';
import { ClientUpdate } from '../interface/clientUpdate';
import { UserCreationResponse } from '../interface/userCreationResponse';

@Injectable({
    providedIn: 'root',
})

export class AuthServicio {

    private _authenticated: boolean = false;

    private url: string = 'Auth/';

    /** Propiedad configuración */
    private configSession: string = 'Usuario';
    private configForms: string = 'Formularies';


    constructor(
        private _http: HttpClient,
        private _router: Router) {
    }

    Login(login: Login): Observable<RespuestaApi> {
        let body = JSON.stringify(login);
        const url = `${this.url}user`;
        return this._http.post<RespuestaApi>(url, body)
    }

    formsInfo(){
        const url = `${this.url}formConfig`;
        return this._http.get<FormConfig>(url)
    }

    createUser(newUser: ClientEntity){
        let body = JSON.stringify(newUser);
        const url = `${this.url}create`;
        return this._http.post<UserCreationResponse>(url, body)
    }

    updateUser(User: ClientUpdate){
        let body = JSON.stringify(User);
        const url = `${this.url}update`;
        return this._http.post<ClientUpdate>(url, body)
    }

    cerrarSesion()
    {
        localStorage.removeItem(this.configSession);
        localStorage.removeItem(this.configForms);
        return of(true);
    }

    set session(auth: RespuestaApi) {
        localStorage.setItem(this.configSession, JSON.stringify(auth));
    }
    
    set FormsData(data: FormConfig) {
        localStorage.setItem(this.configForms, JSON.stringify(data));
    }

    get FormsData(): FormConfig{
        const formsJson = localStorage.getItem(this.configForms);
        const session: FormConfig = formsJson !== null ? JSON.parse(formsJson) : null;
        return session;

    }

    get session(): RespuestaApi {
        if (localStorage.getItem(this.configSession) === null) {
            this._router.navigate(['']);
        }
        const sessionJson = localStorage.getItem(this.configSession);
        const session: RespuestaApi = sessionJson !== null ? JSON.parse(sessionJson) : null;
        return session;
    }

}