import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ModuleService } from './services/module.service';
import { HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule , FormsModule } from '@angular/forms';
import { ModuleComponent } from './back-office/module/module.component';
import { RouterModule } from '@angular/router';
import { AttributComponent } from './back-office/attribut/attribut.component';
import { AttributService } from './services/attribut.service';

@NgModule({
  declarations: [
    ModuleComponent,
    AppComponent,
    AttributComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule ,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ],
  providers: [ModuleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
