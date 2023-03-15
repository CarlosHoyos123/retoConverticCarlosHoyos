import { Route } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';

export const AuthRutas: Route[] = [
    { path: '', component: LoginComponent },
    { path: 'registro', component: RegistroComponent },
]