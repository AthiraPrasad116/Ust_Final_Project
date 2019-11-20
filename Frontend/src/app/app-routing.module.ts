import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewVenderComponent } from './view-vender/view-vender.component';
import { AddVenderComponent } from './add-vender/add-vender.component';


const routes: Routes = [
  {path:'',component: LoginComponent},
  {path:'viewVender',component: ViewVenderComponent},
  {path:'addVender',component: AddVenderComponent},
  {path:'editVender/:venderId',component: AddVenderComponent},
  {path:'Logout',component: LoginComponent},
  {path:'back',component: ViewVenderComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
