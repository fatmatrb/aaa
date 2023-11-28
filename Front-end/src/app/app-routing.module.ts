import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ModuleComponent } from './back-office/module/module.component';
import { AttributComponent } from './back-office/attribut/attribut.component';

const routes: Routes = [
  { path: '', redirectTo: '/modules', pathMatch: 'full' },
  { path: 'modules', component: ModuleComponent },
 { path: 'attributs', component: AttributComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
