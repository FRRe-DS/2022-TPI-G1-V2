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
import { ForDirective } from './directives/for.directive';
import { RedDirective } from './directives/red.directive';
import { AppRoutingModule } from './app-routing.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { HealthRead2Component } from './shared/components/health/health-read2/health-read2.component';
import { HealthCreateComponent } from './shared/components/health/health-create/health-create.component';
import { HealthReadComponent } from './shared/components/health/health-read/health-read.component';
import { HealthUpdateComponent } from './shared/components/health/health-update/health-update.component';
import { HealthDeleteComponent } from './shared/components/health/health-delete/health-delete.component';
import { MatCardModule } from '@angular/material/card';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginSignupComponent,
    HealthCrudComponent,
    HealthRead2Component,
    HealthCreateComponent,
    HealthReadComponent,
    HealthUpdateComponent,
    HealthDeleteComponent,
    RedDirective,
    ForDirective,
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule,
    MatToolbarModule,
    MatSortModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatCardModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


