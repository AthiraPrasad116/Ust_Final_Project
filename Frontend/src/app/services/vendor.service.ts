import { Injectable } from '@angular/core';
import { Vender } from '../vender';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private _httpService : HttpClient) { }

  getAllVendorDetails(): Observable<Vender[]>{
    return this._httpService.get<Vender[]>(environment.APIUrl +'/api/viewVenders');
  }

  disableVender(venderId:number): Observable<Vender>{
    let body = JSON.stringify(venderId);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpService.put<Vender>(environment.APIUrl +'api/disableVender/'+ venderId,body,options);
  }

  searchVendor(searchString : string): Observable<Vender[]>{
    return this._httpService.get<Vender[]>(environment.APIUrl +'/vendersearch/'+ searchString);
    
  }


}
