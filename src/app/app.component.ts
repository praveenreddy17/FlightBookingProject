import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { AdminService } from './admin.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  constructor(private adminService:AdminService,private router:Router){}
  ngOnInit(): void {
   this.adminService.isAdminStr.subscribe(res=>{this.isAdmin=res})
   this.adminService.isLoggedInStr.subscribe(res=>{this.isLoggedIn=res})
   this.router.events.subscribe((val)=>{
     if(val instanceof NavigationEnd){
      this.adminService.isAdminStr.subscribe(res=>{this.isAdmin=res})
      this.adminService.isLoggedInStr.subscribe(res=>{this.isLoggedIn=res})
     }
   })
  }
  title = 'flight-project';
  isLoggedIn:boolean=false;
  isAdmin:boolean=false;

  logout(){
    window.sessionStorage.clear();
    this.adminService.setIsAdmin(false);
    this.adminService.setIsLoggedIn(false);
    this.router.navigate(["/signin"])
  }
}
