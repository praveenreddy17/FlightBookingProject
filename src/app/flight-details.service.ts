import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FlightDetailsService {
    constructor(private http:HttpClient) { }
  
  
    public doRegistration(Flight:any){
      return this.http.post("http://localhost:8084/flight/saveFlight",Flight,{responseType:'text' as 'json'});
    }
  
    public getAllFlights(){
      return this.http.get("http://localhost:8084/flight/listOfFlights");
    }
  
  
    public deleteFlight(id: string | number){
      return this.http.delete("http://localhost:8084/flight//"+id);
    }
  }
  
