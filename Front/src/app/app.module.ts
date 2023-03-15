import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';


/** Componentes */
import { AppComponent } from './app.component';
import { LayoutLoginComponent } from './modulos/layaout/layout-login/layout-login.component';
import { LayoutHomeComponent } from './modulos/layaout/layout-home/layout-home.component';
import { appRutas } from './app.routing';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './servicios/base/inteceptor';
import { NavBarComponent } from './modulos/layaout/layout-home/navigationBar/nav-bar/nav-bar.component';
import { BestSellsComponent } from './modulos/home/best-sells/best-sells.component';
import { BannerComponent } from './modulos/layaout/layout-home/banner/banner/banner.component';
import { ProductsComponent } from './modulos/layaout/layout-home/salient/products/products.component';
import { LayoutDescriptionComponent } from './modulos/layaout/layout-description/layout-description.component';
import { ProfileDescriptionComponent } from './modulos/detailed/profile_description/profile-description/profile-description.component';



@NgModule({
  declarations: [
    AppComponent,
    LayoutLoginComponent,
    LayoutHomeComponent,
    BestSellsComponent,
    NavBarComponent,
    BannerComponent,
    ProductsComponent,
    LayoutDescriptionComponent,
    ProfileDescriptionComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRutas)
  ],
  providers:
    [
      {
        provide: HTTP_INTERCEPTORS,
        useClass: Interceptor,
        multi: true
      },
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
