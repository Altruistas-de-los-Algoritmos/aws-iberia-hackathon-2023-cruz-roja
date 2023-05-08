import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { InicioComponent } from './components/inicio/inicio.component';
import { AcogidaComponent } from './components/acogida/acogida.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { FormComponent } from './components/form/form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ResumenComponent } from './components/resumen/resumen.component';
import { MensajeComponent } from './components/mensaje/mensaje.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    InicioComponent,
    AcogidaComponent,
    FormComponent,
    ResumenComponent,
    MensajeComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
