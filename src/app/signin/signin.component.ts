import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private adminService:AdminService,private router: Router) { }
  user:any={};
  ngOnInit(): void {
  }
login(user:any){
  this.adminService.login(user).subscribe({
    next:(res)=>this.handleResponse(res),
    error:(err)=>this.handleError(err)
  })
}
  handleResponse(res: any): void {
    console.log(res);
    if(res!=null){
      let uObj=JSON.parse(res);
    window.sessionStorage.setItem("userName",uObj.userName);
    window.sessionStorage.setItem("isAdmin",uObj.isAdmin);  
    this.adminService.setIsLoggedIn(true);
    if(uObj.isAdmin=='Y'){
    this.adminService.setIsAdmin(true);
  }else{
    this.adminService.setIsAdmin(false);
  }
    this.router.navigate(["/home"])   
    }else{
      alert("Please try again.")
    }
    
  }

  handleError(res: any): void {
    
      alert("Please try again.")
    
    
  }
}
