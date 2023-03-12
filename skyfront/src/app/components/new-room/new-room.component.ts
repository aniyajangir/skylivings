import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { faWifi } from '@fortawesome/free-solid-svg-icons';
import { faElevator } from '@fortawesome/free-solid-svg-icons';
import { faTelevision } from '@fortawesome/free-solid-svg-icons';
import { Room } from 'src/app/classes/room';
import { PropertyServiceService } from 'src/app/service/property-service.service';

@Component({
  selector: 'app-new-room',
  templateUrl: './new-room.component.html',
  styleUrls: ['./new-room.component.css']
})
export class NewRoomComponent implements OnInit {

  wifiIcon = faWifi;
  elecatorIcon = faElevator;
  tvIcon = faTelevision;

  room!: Room;
 
  roomForm = new FormGroup({
    propertyType: new FormControl(''),
    roomNumber: new FormControl(''),
    roomSize: new FormControl(''),
    capacity: new FormControl(''),
    bedrooms: new FormControl(''),
    bathrooms: new FormControl(''),
    rent: new FormControl(''),
    deposit: new FormControl(''),
    description: new FormControl(''),
    quantity: new FormControl('')

  })

  constructor(private propertyService: PropertyServiceService) { }

  // quantities() : FormArray {  
  //   return this.roomForm.get("quantities") as FormArray  
  // }  

  ngOnInit(): void {
  }

  onSumbit(){
    this.addNewRoom();
  }

  addNewRoom(){
    this.propertyService.createRoom(this.roomForm.value).subscribe(data =>  {
      console.log(data);
    });
  }
}
