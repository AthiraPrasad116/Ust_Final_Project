import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Vender } from '../vender';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private _httpService:HttpClient,private _router:Router) { }

  LoginCheck(formData:any):any{
    return this._httpService.get<Vender>(environment.APIUrl+'api/login/'+formData.username+'/'+formData.password);
  }
}
