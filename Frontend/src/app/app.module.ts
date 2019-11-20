import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ViewVenderComponent } from './view-vender/view-vender.component';
import { AddVenderComponent } from './add-vender/add-vender.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginService } from './services/login.service';
import { VendorService } from './services/vendor.service';
import { VendorCrudsService } from './services/vendor-cruds.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewVenderComponent,
    AddVenderComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [LoginService , VendorCrudsService , VendorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
