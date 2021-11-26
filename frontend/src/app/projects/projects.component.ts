import { Component, OnInit } from '@angular/core';
import {RedUser} from "../models/reduser";
import {RedPair} from "../models/redpair";
import {AppService} from "../services/app.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {RedProject} from "../models/redproject";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  allRedProjects: RedProject[] = [];
  aRedProjects: RedProject[] = [];
  bRedProjects: RedProject[] = [];

  currentPairs : RedPair[] = [];

  constructor(private appService: AppService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAllRedProjects();
    this.getProjectPairs();
  }

  async getAllRedProjects() {
    this.allRedProjects = await this.appService.getAllRedProjects();
    this.allRedProjects.forEach(project => project.display = project.name);
    this.allRedProjects.forEach(project => {
      if(project.systemid === 1 && project.name !== '') {
        if(this.aRedProjects.find(aProject => aProject.name === project.name && aProject.systemid === project.systemid) === undefined){
          this.aRedProjects.push(project);
        }
      } else if(project.systemid === 2 && project.name !== '') {
        if(this.bRedProjects.find(bProject => bProject.name === project.name && bProject.systemid === project.systemid) === undefined){
          this.bRedProjects.push(project);
        }
      }
    });
  }

  async getProjectPairs() {
    this.currentPairs = await this.appService.getProjectPairs();
    console.log(this.currentPairs);
  }


  async connectSelectedProjects(pair: RedPair) {
    await this.appService.connectProjects(pair.aid, pair.bid);
    await this.getProjectPairs();
    this.openSnackBar('Successful connection!', 'Ok');
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action,{
      duration:  2000
    });

  }

  async refreshProjects() {
    await this.appService.refreshProjects();
    await this.getAllRedProjects();
    this.openSnackBar("Projectss refreshed!", "Ok");
  }



  async deleteConnection(pair: RedPair) {
    await this.appService.deleteProjectConnection(pair.aid, pair.bid);
    await this.getProjectPairs();
    this.openSnackBar('Successful deletion!', 'Ok');
  }

}
