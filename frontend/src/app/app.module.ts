import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UsersComponent } from './users/users.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatListModule} from '@angular/material/list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatCardModule} from "@angular/material/card";
import { UserSubComponent } from './users/user-sub/user-sub.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { HomeComponent } from './home/home.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSelectModule} from "@angular/material/select";
import { ProjectsComponent } from './projects/projects.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UsersComponent,
    UserSubComponent,
    NavBarComponent,
    HomeComponent,
    ProjectsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatListModule,
    BrowserAnimationsModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatSnackBarModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatToolbarModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
