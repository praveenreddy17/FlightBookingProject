import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-allbookings',
  templateUrl: './allbookings.component.html',
  styleUrls: ['./allbookings.component.css']
})
export class AllbookingsComponent implements OnInit {

  constructor(private adminService:AdminService,private router:Router) { }
  

  bookings=[{date:'',flightName:'',fromPlace:'',toPlace:'',cost:'',noOfPassengers:'',totalCost:'',isActive:''}];
  ngOnInit(): void {
    this.getAllFlights();
  }
  getAllFlights(){
this.adminService.getAllFlights().subscribe(
  {
    next:res=>{this.handleResponse(res)},
    error:res=>{this.handleError(res)}
}

)
  }
  handleResponse(res: any): void {
    if(res!=null){
      this.bookings=res;
    }else{
      alert("No flights available.")
    }
   }
 
   handleError(err:any):void {
     alert("Please try again.");
   }
   deleteFlight(userBooking:any){
    this.adminService.deleteFlight(userBooking.id).subscribe(
      {
        next:res=>{this.handleBookingResponse(res)},
        error:res=>{this.handleError(res)}
    }
    )
  }
  handleBookingResponse(res: any): void {
    if(res!=null){
      alert("Flight deleted Successfully.")
      this.getAllFlights();
    }else{
      alert("No flights available.")
    }
   }
   goHome(){
     this.router.navigate(["/home"]);
   }
  }


