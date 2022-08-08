import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  constructor(private adminService:AdminService,private router: Router) { }
  user:any={};
  ngOnInit(): void {
  }
register(user:any){
  this.adminService.createUser(user).subscribe({
    next:(res)=>this.handleResponse(res),
    error:(err)=>this.handleError(err)
  })
}
  handleResponse(res: any): void {
   alert("You have successfully registered.Please login.");
   this.router.navigate(["/signin"]);
  }

  handleError(err:any):void {
    alert("Please try again.");
  }
}


