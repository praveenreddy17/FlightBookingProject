import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-newbooking',
  templateUrl: './newbooking.component.html',
  styleUrls: ['./newbooking.component.css']
})
export class NewbookingComponent implements OnInit {

  constructor(private adminService:AdminService,private router:Router) { }
  search:any={};
  passengers:number=0;
  cost:number=0;
  bookings=[{date:'',flightName:'',fromPlace:'',toPlace:'',cost:this.cost,noOfPassengers:this.passengers,totalCost:''}];
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
  }
  searchFlight(search:any){
this.adminService.searchFlights(search).subscribe(
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
  bookFlight(userBooking:any){
    this.adminService.bookFlight(userBooking).subscribe(
      {
        next:res=>{this.handleBookingResponse(res)},
        error:res=>{this.handleError(res)}
    }
    )
  }
  handleBookingResponse(res: any): void {
    if(res!=null){
alert("You have successfully booked your flight");
this.router.navigate(["/myBookings"])
    }else{
      alert("No flights available.")
    }
   }
}
