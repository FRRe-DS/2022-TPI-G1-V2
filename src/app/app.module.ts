import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/components/template/header/header.component';
import { FooterComponent } from './shared/components/template/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HomeComponent } from './views/home/home.component';
import { LoginSignupComponent } from './login-signup/login-signup.component';
import { HealthCrudComponent } from './views/health/health.component';
import { HealthReadComponent } from './shared/components/health/health-read/health-read.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginSignupComponent,
    HealthCrudComponent,
    HealthReadComponent,
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }