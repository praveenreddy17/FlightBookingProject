import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { MybookingsComponent } from './mybookings/mybookings.component';
import { AllbookingsComponent } from './allbookings/allbookings.component';
import { NewbookingComponent } from './newbooking/newbooking.component';
import { AddflightComponent } from './addflight/addflight.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,  
    SigninComponent,
    SignupComponent,
    MybookingsComponent,
    AllbookingsComponent,
    NewbookingComponent,
    AddflightComponent
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
