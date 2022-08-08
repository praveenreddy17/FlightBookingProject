import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-mybookings',
  templateUrl: './mybookings.component.html',
  styleUrls: ['./mybookings.component.css']
})
export class MybookingsComponent implements OnInit {

  constructor(private adminService:AdminService,private router:Router) { }
  search:any={};
  bookings=[{date:'',flightName:'',fromPlace:'',toPlace:'',cost:'',noOfPassengers:'',totalCost:''}];
cityList=[
  'banglore',
  'Chennai',
  'Delhi',
 'Hyderabad',
  'Kolkata',
  'Mumbai',
  'Pune',
  'Rajasthan',
  'Ranchi'
]
  ngOnInit(): void {
    this.getFlightsOfUser(window.sessionStorage.getItem("userName"));
  }
  getFlightsOfUser(search:any){
this.adminService.getUserFlights(search).subscribe(
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
    this.adminService.deleteUserFlight(userBooking.id).subscribe(
      {
        next:res=>{this.handleBookingResponse(res)},
        error:res=>{this.handleError(res)}
    }
    )
  }
  handleBookingResponse(res: any): void {
    if(res!=null){
       this.getFlightsOfUser(window.sessionStorage.getItem("userName"));

    }else{
      alert("No flights available.")
    }
   }
   goHome(){
     this.router.navigate(["/home"]);
   }
  }
