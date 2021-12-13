import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {UsersComponent} from "./users/users.component";
import {HomeComponent} from "./home/home.component";
import {ProjectsComponent} from "./projects/projects.component";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'users', component: UsersComponent},
  {path: 'home', component: HomeComponent},
  {path: 'projects', component: ProjectsComponent},
];
// /users?system=1
// /system/1/users
@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
