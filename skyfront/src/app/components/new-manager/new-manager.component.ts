import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Manager } from 'src/app/classes/manager';
import { ManagerServiceService } from 'src/app/service/manager-service.service';

@Component({
  selector: 'app-new-manager',
  templateUrl: './new-manager.component.html',
  styleUrls: ['./new-manager.component.css']
})
export class NewManagerComponent implements OnInit {

  manager:Manager = new Manager();

  constructor(private managerService:ManagerServiceService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
      console.log();
      this.saveManager()
  }

  saveManager(){
    this.managerService.createManager(this.manager).subscribe(data => 
      {
        this.goToManagerList();
        console.log(data);
      },
      error => console.log(error));
  }

  goToManagerList(){
    this.router.navigate(["/property-tenants"]);
  }

}
