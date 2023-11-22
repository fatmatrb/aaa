import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ModuleService } from './services/module.service';
import { HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ModuleComponent } from './back-office/module/module.component';

@NgModule({
  declarations: [
    ModuleComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule ,
    ReactiveFormsModule
  ],
  providers: [ModuleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
