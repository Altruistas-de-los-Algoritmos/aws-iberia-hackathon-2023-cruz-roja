import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { InicioComponent } from './components/inicio/inicio.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    InicioComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
