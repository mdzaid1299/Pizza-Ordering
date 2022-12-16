import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { customerClass } from './customerClass';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient:HttpClient) { }
  url4="http://localhost:8082/api/v2/register";
  storeData(regData2: customerClass): Observable<customerClass>{
    console.log("register user is working");
    return this.httpClient.post<customerClass>(`${this.url4}`,regData2,{responseType:'text' as 'json'});
  }
 
}
