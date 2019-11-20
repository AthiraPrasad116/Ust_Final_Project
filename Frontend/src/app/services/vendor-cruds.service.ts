import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Vender } from '../vender';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendorCrudsService {

  constructor(private _httpService:HttpClient,private _router:Router) { }

  saveVenders(vender:Vender){
    let body=JSON.stringify(vender);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
    
    if(vender.venderId == 0 ){
      return this._httpService.post(environment.APIUrl +'/api/insertVender',body,options);
    }
    else{
      return this._httpService.put(environment.APIUrl +'/api/insertVender',body,options);
    }
  }
 
 getVenderById(venderId:number): Observable<Vender>{
    return this._httpService.get<Vender>(environment.APIUrl +'/api/getVenderByid/'+ venderId);
  }

}
