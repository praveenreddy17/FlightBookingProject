import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserRegService {
  constructor(private http:HttpClient) { }


  public doRegistration(user:any){
    return this.http.post("http://localhost:8081/user/createUser",user,{responseType:'text' as 'json'});
  }

  public getUsers(){
    return this.http.get("http://localhost:8081/user/getAllUsers");
  }

  public getUserByEmail(email: string){
    return this.http.get("http://localhost:8081/findUser/"+email);
  }

  public deleteUser(id: string | number){
    return this.http.delete("http://localhost:8081/user/deleteUser/"+id);
  }
}
