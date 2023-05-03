import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from '../components/inicio/inicio.component';
import { AcogidaComponent } from '../components/acogida/acogida.component';

const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  { path: 'acogida', component: AcogidaComponent },
  { path:'', redirectTo: '/inicio', pathMatch: 'full'},
  { path:'**', component: InicioComponent}
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
