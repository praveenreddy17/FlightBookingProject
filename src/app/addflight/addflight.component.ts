import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-addflight',
  templateUrl: './addflight.component.html',
  styleUrls: ['./addflight.component.css']
})
export class AddflightComponent implements OnInit {

  constructor(private adminService:AdminService,private router: Router) { }
  flight:any={};
  ngOnInit(): void {
  }
  addflight(flight:any){
  this.adminService.addflight(flight).subscribe({
    next:(res)=>this.handleResponse(res),
    error:(err)=>this.handleError(err)
  })
}
  handleResponse(res: any): void {
   alert("you have sucessfully added flight")
  }

  handleError(err:any) {
    alert("Please try again.")
  }
}

