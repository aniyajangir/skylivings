import { Component, OnInit } from '@angular/core';
import { Manager } from 'src/app/classes/manager';
import { ManagerServiceService } from 'src/app/service/manager-service.service';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {

  constructor(private managerService:ManagerServiceService) { }

  managers!: Manager[];

  ngOnInit(): void {
    this.getManagers();
  }
  
  getManagers(){
    this.managerService.getManagerList().subscribe(data => 
      {
        this.managers = data;
      });
  }
}
