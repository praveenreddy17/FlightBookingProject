import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddflightComponent } from './addflight/addflight.component';
import { AllbookingsComponent } from './allbookings/allbookings.component';
import { HomeComponent } from './home/home.component';
import { MybookingsComponent } from './mybookings/mybookings.component';
import { NewbookingComponent } from './newbooking/newbooking.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
{path:"",redirectTo:"signin",pathMatch:"full"},
{path:"home",component:HomeComponent},
{path:"signin",component:SigninComponent},
{path:"signup",component:SignupComponent},
{path:"home",component:HomeComponent},
{path:"myBookings",component:MybookingsComponent},
{path:"allBookings",component:AllbookingsComponent},
{path:"newBooking",component:NewbookingComponent},
{path:"addFlight",component:AddflightComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
